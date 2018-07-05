package com.example.keinonen.inventoryapp01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.keinonen.inventoryapp01.data.InventoryContract.InventoryEntry;
import com.example.keinonen.inventoryapp01.data.InventoryDbHelper;

public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the product's name */
    private EditText nameEditText;

    private EditText priceEditText;

    private EditText quantityEditText;

    private Spinner supplierSpinner;

    private int supplier = 0;

    private EditText phonenumberEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        nameEditText = (EditText) findViewById(R.id.edit_product_name);
        priceEditText = (EditText) findViewById(R.id.edit_product_price);
        quantityEditText = (EditText) findViewById(R.id.edit_product_quantity);
        supplierSpinner = (Spinner) findViewById(R.id.spinner_supplier);
        phonenumberEditText = (EditText) findViewById(R.id.edit_product_phonenumber);

        setupSpinner();
    }

    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_supplier_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        supplierSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        supplierSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.supplier_ebay))) {
                        supplier = InventoryEntry.SUPPLIER_EBAY;
                    } else if (selection.equals(getString(R.string.supplier_market))) {
                        supplier = InventoryEntry.SUPPLIER_MARKET;
                    } else {
                        supplier = InventoryEntry.SUPPLIER_UNKNOWN;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) { supplier = 0;
            }
        });
    }

    /**
     * Get user input from editor and save new pet into database.
     */
    private void insertProduct(){
        //Read from input fields
        // Use trim to eliminate loading or trailing white space
        String nameString = nameEditText.getText().toString().trim();
        String priceString = priceEditText.getText().toString().trim();
        int price = Integer.parseInt(priceString);
        String quantityString = quantityEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityString);
        String phonenumberString = phonenumberEditText.getText().toString().trim();
        int phonenumber = Integer.parseInt(phonenumberString);


        //create database helper
        InventoryDbHelper newInventoryDbHelper = new InventoryDbHelper(this);

        //Gets the database in write mode
        SQLiteDatabase db = newInventoryDbHelper.getWritableDatabase();

        //Create a ContentValues object where column names are the keys,
        //and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, nameString);
        values.put(InventoryEntry.COLUMN_PRODUCT_PRICE, price);
        values.put(InventoryEntry.COLUMN_PRODUCT_QUANTITY, quantity);
        values.put(InventoryEntry.COLUMN_PRODUCT_SUPPLIER, supplier);
        values.put(InventoryEntry.COLUMN_PRODUCT_PHONENUMBER, phonenumber);

        //Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(InventoryEntry.TABLE_NAME, null, values);

        //Show toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            //If the row id is -1, then there was an error with the insertion
            Toast.makeText(this, "Error with saving product", Toast.LENGTH_SHORT).show();
        } else {
            //Otherwise, the insertion was successful and we can display a toast with the row ID
            Toast.makeText(this, "Product saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save product to database
                insertProduct();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
