package com.app.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apitest.Pojo.PanDetails;
import com.app.apitest.Retrofit.ApiService;
import com.app.apitest.Retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Spinner gender,maritalStatus,housing,empType,empStability,bankName,bankPeriod,geoLimit;
    TextInputEditText pan,name,mydob,dependents,houseYrs,grossSalary,netSalary,address,pin,district,state;
    Button panVerify,next;
    ProgressDialog prg;

    String[] gen = { "Select gender","Male", "Female"};
    String[] mar = {"Select marital status","Single","Married"};
    String[] house = {"Select house type","Owned","Rented"};
    String[] emp = {"Select employment type","Salaried","Self emp. professional","Self employed","other"};
    String[] stability = {"Select employment stability","Salaried with over 3 Years","Salaried with over 2 Years",
            "Salaried with over 1 Year","other"};
    String[] banks = {"Select bank","HDFC","AXIS","ICICI"};
    String[] period = {"Select banking period","Account over 2 years","Account over 1 and above",
            "Account over 6 months","other"};
    String[] geo = {"Select geo limit","Less than 15km","Greater than 15km"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edittext
        pan = findViewById(R.id.pan);
        name = findViewById(R.id.name);
        mydob = findViewById(R.id.dob);
        dependents = findViewById(R.id.dependents);
        houseYrs = findViewById(R.id.houseYrs);
        grossSalary = findViewById(R.id.grossSalary);
        netSalary = findViewById(R.id.netSalary);
        address = findViewById(R.id.address);
        pin = findViewById(R.id.pin);
        district = findViewById(R.id.district);
        state = findViewById(R.id.state);

        //button
        panVerify = findViewById(R.id.panVerify);
        next = findViewById(R.id.next);

        //Spinners
        gender = findViewById(R.id.gender);
        maritalStatus = findViewById(R.id.maritalStatus);
        housing = findViewById(R.id.housing);
        empType = findViewById(R.id.empType);
        empStability = findViewById(R.id.empStability);
        bankName = findViewById(R.id.bankName);
        bankPeriod = findViewById(R.id.bankPeriod);
        geoLimit = findViewById(R.id.geoLimit);

        ArrayAdapter genderAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gen);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter marAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mar);
        marAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maritalStatus.setAdapter(marAdapter);

        maritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter houseAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,house);
        houseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        housing.setAdapter(houseAdapter);

        housing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter empAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,emp);
        empAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empType.setAdapter(empAdapter);

        empType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter stableAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,stability);
        stableAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empStability.setAdapter(stableAdapter);

        empStability.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter banksAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,banks);
        banksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankName.setAdapter(banksAdapter);

        bankName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter periodAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,period);
        periodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankPeriod.setAdapter(periodAdapter);

        bankPeriod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter geoAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,geo);
        geoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        geoLimit.setAdapter(geoAdapter);

        geoLimit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView)parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        panVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg = new ProgressDialog(MainActivity.this);
                prg.setMessage("Getting info...");
                prg.setCancelable(false);
                prg.show();

                if(pan.getText().toString().equals("")){

                    prg.dismiss();
                    Toast.makeText(getApplicationContext(),"Enter pan no",Toast.LENGTH_SHORT).show();
                }
                else if(pan.getText().toString().length() != 10){

                    prg.dismiss();
                    Toast.makeText(getApplicationContext(),"Invalid pan no",Toast.LENGTH_SHORT).show();
                }
                else{

                    sendPan(pan.getText().toString());
                }
            }
        });
    }

    private void sendPan(String str1){

        Retrofit retrofit = RetrofitClient.getInstance();
        ApiService apiService = retrofit.create(ApiService.class);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("panNo",str1);

        apiService.getDetails(jsonObject).subscribeOn(Schedulers.io())
                .subscribe(new Observer<PanDetails>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PanDetails value) {

                        prg.dismiss();

                        name.setText(value.getPanHolderName());
                        mydob.setText(value.getDateOfBirth());
                        address.setText(value.getAddress());
                        pin.setText(value.getPincode());
                        if(value.getGender().equals("Male")){
                            gender.setSelection(1);
                        }
                        else{
                            gender.setSelection(2);
                        }
                    }

                    @Override
                    public void onError(final Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });  
    }

}