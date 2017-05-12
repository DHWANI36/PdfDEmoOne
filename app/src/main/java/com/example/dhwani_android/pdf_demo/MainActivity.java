package com.example.dhwani_android.pdf_demo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.RangeValueIterator;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.bPressMe);



        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {



                File pdfFile = new File(Environment

                                .getExternalStorageDirectory(), "Case Study.pdf");



                try {

                    if (pdfFile.exists()) {

                        Uri path = Uri.fromFile(pdfFile);

                        Intent objIntent = new Intent(Intent.ACTION_VIEW);

                        objIntent.setDataAndType(path, "application/pdf");

                        objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        startActivity(objIntent);

                    } else {

                        Toast.makeText(MainActivity.this, "File NotFound",

                                Toast.LENGTH_SHORT).show();

                    }

                } catch (ActivityNotFoundException e) {

                    Toast.makeText(MainActivity.this,

                            "No Viewer Application Found", Toast.LENGTH_SHORT)

                            .show();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        });

    }
}
