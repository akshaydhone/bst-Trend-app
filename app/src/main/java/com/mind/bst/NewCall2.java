package com.mind.bst;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class NewCall2 extends AppCompatActivity {

    private static final String TAG = "NewCall2";
//step1
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public static EditText e1;

    public static TextView e4,e5,e6;
    //public static Spinner s4;
    Button b1;
    TimePickerDialog picker;
    private FirebaseAuth mAuth;
    TextView username;

    public static TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;


    public static TextView mDisplayDate,mReschdeuledDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener,mDateSetListener1;

   public static MultipleSelectionSpinner s4;

    //List which hold multiple selection spinner values
    //List<String> list = new ArrayList<String>();
    List<String> listinspection = new ArrayList<String>();

    List<String> listautomation = new ArrayList<String>();
    List<String> listdefectdetsystem = new ArrayList<String>();
    List<String> listdensitythickness = new ArrayList<String>();
    List<String> listmirrorimagereg = new ArrayList<String>();
    List<String> listregisterandviscocity = new ArrayList<String>();
    List<String> listregistercotrol = new ArrayList<String>();
    List<String> listspecialpurposemachine = new ArrayList<String>();
    List<String> listsurfaceinspection = new ArrayList<String>();
    List<String> listwebguiding = new ArrayList<String>();
    List<String> listwebtensioncontrol = new ArrayList<String>();
    List<String> listwebvideoinspection = new ArrayList<String>();



    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call2);
        //s4 = (Spinner) findViewById(R.id.s4);


      getSupportActionBar().setTitle("Call Attend");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        s4 = findViewById(R.id.s4);

        //adding items to list


        //adding items to the another list
        listinspection.add("Area-Scan Camera");
        listinspection.add("Cable / Cork Tape / Timing Belt");
        listinspection.add("Camera Lens Assembly");
        listinspection.add("Control Panel");
        listinspection.add("Drive");
        listinspection.add("Encoder");
        listinspection.add("Flash");



        listinspection.add("HMI Monitor");
        listinspection.add("Infrared Sensor");
        listinspection.add("Keyboard / Keypad");
        listinspection.add("LED / Lights / Illumination");
        listinspection.add("Line-Scan Camera");
        listinspection.add("MHRM Sensor");
        listinspection.add("Monitor (TFT / LED / LCD / HD / UHD)");



        listinspection.add("Monitor (Touch Screen)");
        listinspection.add("Motor / BLDC Motor");
        listinspection.add("Mounting Bracket");
        listinspection.add("Mouse / Joystick");
        listinspection.add("Other Spare Parts ");
        listinspection.add("PCB Board");
        listinspection.add("Power Supply");


        listinspection.add("Register Mark Sensor");
        listinspection.add("Roller");
        listinspection.add("Strobe / Halogen Bulb");
        listinspection.add("Transformer");
        listinspection.add("Traverse");
        listinspection.add("Ultrasonic Sensor");
        listinspection.add("X-Rite Sensor");

        listinspection.add("Sensor");

        //Automation List


        listautomation.add("Cable / Cork Tape / Timing Belt");
        listautomation.add("Control Panel");
        listautomation.add("Drive");
        listautomation.add("Encoder");
        listautomation.add("Flash");
        listautomation.add("HMI Monitor");
        listautomation.add("Infrared Sensor");
        listautomation.add("Keyboard / Keypad ");

        listautomation.add("LED / Lights / Illumination");
        listautomation.add("MHRM Sensor");
        listautomation.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listautomation.add("Monitor (Touch Screen)");
        listautomation.add("Motor / BLDC Motor");
        listautomation.add("Mounting Bracket");
        listautomation.add("Mouse / Joystick");
        listautomation.add("Other Spare Parts");


        listautomation.add("PCB Board");
        listautomation.add("Power Supply");
        listautomation.add("Roller");
        listautomation.add("Strobe / Halogen Bulb");
        listautomation.add("Transformer");
        listautomation.add("Traverse");
        listautomation.add("Ultrasonic Sensor");
        listautomation.add("Sensor");



        //Defect detection system list


        listdefectdetsystem.add("Area-Scan Camera");
        listdefectdetsystem.add("Cable / Cork Tape / Timing Belt");
        listdefectdetsystem.add("Camera Lens Assembly");
        listdefectdetsystem.add("Control Panel");
        listdefectdetsystem.add("Drive");
        listdefectdetsystem.add("Encoder");
        listdefectdetsystem.add("Flash");



        listdefectdetsystem.add("HMI Monitor");
        listdefectdetsystem.add("Infrared Sensor");
        listdefectdetsystem.add("Keyboard / Keypad");
        listdefectdetsystem.add("LED / Lights / Illumination");
        listdefectdetsystem.add("Line-Scan Camera");
        listdefectdetsystem.add("MHRM Sensor");
        listdefectdetsystem.add("Monitor (TFT / LED / LCD / HD / UHD)");



        listdefectdetsystem.add("Monitor (Touch Screen)");
        listdefectdetsystem.add("Motor / BLDC Motor");
        listdefectdetsystem.add("Mounting Bracket");
        listdefectdetsystem.add("Mouse / Joystick");
        listdefectdetsystem.add("Other Spare Parts ");
        listdefectdetsystem.add("PCB Board");
        listdefectdetsystem.add("Power Supply");


        listdefectdetsystem.add("Register Mark Sensor");
        listdefectdetsystem.add("Roller");
        listdefectdetsystem.add("Strobe / Halogen Bulb");
        listdefectdetsystem.add("Transformer");
        listdefectdetsystem.add("Traverse");
        listdefectdetsystem.add("Ultrasonic Sensor");


        listdefectdetsystem.add("Sensor");



        //density and thickness list

        listdensitythickness.add("Cable / Cork Tape / Timing Belt");
        listdensitythickness.add("Control Panel");
        listdensitythickness.add("Drive");
        listdensitythickness.add("Encoder");

        listdensitythickness.add("HMI Monitor");
        listdensitythickness.add("Infrared Sensor");
        listdensitythickness.add("Keyboard / Keypad ");

        listdensitythickness.add("LED / Lights / Illumination");
        listdensitythickness.add("MHRM Sensor");
        listdensitythickness.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listdensitythickness.add("Monitor (Touch Screen)");
        listdensitythickness.add("Motor / BLDC Motor");
        listdensitythickness.add("Mounting Bracket");
        listdensitythickness.add("Mouse / Joystick");
        listdensitythickness.add("Other Spare Parts");


        listdensitythickness.add("PCB Board");
        listdensitythickness.add("Power Supply");
        listdensitythickness.add("Roller");
        listdensitythickness.add("Strobe / Halogen Bulb");
        listdensitythickness.add("Transformer");
        listdensitythickness.add("Traverse");
        listdensitythickness.add("Ultrasonic Sensor");
        listdensitythickness.add("Sensor");


        //Mirror image list


        listmirrorimagereg.add("Cable / Cork Tape / Timing Belt");
        listmirrorimagereg.add("Control Panel");
        listmirrorimagereg.add("Drive");
        listmirrorimagereg.add("Encoder");
        listmirrorimagereg.add("Flash");
        listmirrorimagereg.add("HMI Monitor");
        listmirrorimagereg.add("Infrared Sensor");
        listmirrorimagereg.add("Keyboard / Keypad ");

        listmirrorimagereg.add("LED / Lights / Illumination");
        listmirrorimagereg.add("MHRM Sensor");
        listmirrorimagereg.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listmirrorimagereg.add("Monitor (Touch Screen)");
        listmirrorimagereg.add("Motor / BLDC Motor");
        listmirrorimagereg.add("Mounting Bracket");
        listmirrorimagereg.add("Mouse / Joystick");
        listmirrorimagereg.add("Other Spare Parts");


        listmirrorimagereg.add("PCB Board");
        listmirrorimagereg.add("Power Supply");
        listmirrorimagereg.add(" Register Mark Sensor");

        listmirrorimagereg.add("Roller");
        listmirrorimagereg.add("Strobe / Halogen Bulb");
        listmirrorimagereg.add("Transformer");
        listmirrorimagereg.add("Traverse");
        listmirrorimagereg.add("Ultrasonic Sensor");

        listmirrorimagereg.add("X-Rite Sensor");

        listmirrorimagereg.add("Sensor");



        //register and viscocity list



        listregisterandviscocity.add("Cable / Cork Tape / Timing Belt");
        listregisterandviscocity.add("Control Panel");
        listregisterandviscocity.add("Drive");
        listregisterandviscocity.add("Encoder");
        listregisterandviscocity.add("Flash");
        listregisterandviscocity.add("HMI Monitor");
        listregisterandviscocity.add("Infrared Sensor");
        listregisterandviscocity.add("Keyboard / Keypad ");

        listregisterandviscocity.add("LED / Lights / Illumination");
        listregisterandviscocity.add("MHRM Sensor");
        listregisterandviscocity.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listregisterandviscocity.add("Monitor (Touch Screen)");
        listregisterandviscocity.add("Motor / BLDC Motor");
        listregisterandviscocity.add("Mounting Bracket");
        listregisterandviscocity.add("Mouse / Joystick");
        listregisterandviscocity.add("Other Spare Parts");


        listregisterandviscocity.add("PCB Board");
        listregisterandviscocity.add("Power Supply");
        listregisterandviscocity.add(" Register Mark Sensor");

        listregisterandviscocity.add("Roller");
        listregisterandviscocity.add("Strobe / Halogen Bulb");
        listregisterandviscocity.add("Transformer");
        listregisterandviscocity.add("Traverse");
        listregisterandviscocity.add("Ultrasonic Sensor");

        listregisterandviscocity.add("X-Rite Sensor");

        listregisterandviscocity.add("Sensor");



        //register control list


        listregistercotrol.add("Cable / Cork Tape / Timing Belt");
        listregistercotrol.add("Control Panel");
        listregistercotrol.add("Drive");
        listregistercotrol.add("Encoder");
        listregistercotrol.add("Flash");
        listregistercotrol.add("HMI Monitor");
        listregistercotrol.add("Infrared Sensor");
        listregistercotrol.add("Keyboard / Keypad ");

        listregistercotrol.add("LED / Lights / Illumination");
        listregistercotrol.add("MHRM Sensor");
        listregistercotrol.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listregistercotrol.add("Monitor (Touch Screen)");
        listregistercotrol.add("Motor / BLDC Motor");
        listregistercotrol.add("Mounting Bracket");
        listregistercotrol.add("Mouse / Joystick");
        listregistercotrol.add("Other Spare Parts");


        listregistercotrol.add("PCB Board");
        listregistercotrol.add("Power Supply");
        listregistercotrol.add(" Register Mark Sensor");

        listregistercotrol.add("Roller");
        listregistercotrol.add("Strobe / Halogen Bulb");
        listregistercotrol.add("Transformer");
        listregistercotrol.add("Traverse");
        listregistercotrol.add("Ultrasonic Sensor");

        listregistercotrol.add("X-Rite Sensor");

        listregistercotrol.add("Sensor");
        listregistercotrol.add("Control Panel for ARC_18");
        listregistercotrol.add("DGC 650 / DGC 700 / Profinet Cable");


        //special purpose list

        listspecialpurposemachine.add("Area-Scan Camera");
        listspecialpurposemachine.add("Cable / Cork Tape / Timing Belt");
        listspecialpurposemachine.add("Camera Lens Assembly");
        listspecialpurposemachine.add("Control Panel");
        listspecialpurposemachine.add("Drive");
        listspecialpurposemachine.add("Encoder");
        listspecialpurposemachine.add("Flash");



        listspecialpurposemachine.add("HMI Monitor");
        listspecialpurposemachine.add("Infrared Sensor");
        listspecialpurposemachine.add("Keyboard / Keypad");
        listspecialpurposemachine.add("LED / Lights / Illumination");
        listspecialpurposemachine.add("Line-Scan Camera");
        listspecialpurposemachine.add("MHRM Sensor");
        listspecialpurposemachine.add("Monitor (TFT / LED / LCD / HD / UHD)");



        listspecialpurposemachine.add("Monitor (Touch Screen)");
        listspecialpurposemachine.add("Motor / BLDC Motor");
        listspecialpurposemachine.add("Mounting Bracket");
        listspecialpurposemachine.add("Mouse / Joystick");
        listspecialpurposemachine.add("Other Spare Parts ");
        listspecialpurposemachine.add("PCB Board");
        listspecialpurposemachine.add("Power Supply");


        listspecialpurposemachine.add("Register Mark Sensor");
        listspecialpurposemachine.add("Roller");
        listspecialpurposemachine.add("Strobe / Halogen Bulb");
        listspecialpurposemachine.add("Transformer");
        listspecialpurposemachine.add("Traverse");
        listspecialpurposemachine.add("Ultrasonic Sensor");
        listspecialpurposemachine.add("Sensor");



//surface inspection list

        listsurfaceinspection.add("Area-Scan Camera");
        listsurfaceinspection.add("Cable / Cork Tape / Timing Belt");
        listsurfaceinspection.add("Camera Lens Assembly");
        listsurfaceinspection.add("Control Panel");
        listsurfaceinspection.add("Drive");
        listsurfaceinspection.add("Encoder");
        listsurfaceinspection.add("Flash");



        listsurfaceinspection.add("HMI Monitor");
        listsurfaceinspection.add("Infrared Sensor");
        listsurfaceinspection.add("Keyboard / Keypad");
        listsurfaceinspection.add("LED / Lights / Illumination");
        listsurfaceinspection.add("Line-Scan Camera");
        listsurfaceinspection.add("MHRM Sensor");
        listsurfaceinspection.add("Monitor (TFT / LED / LCD / HD / UHD)");



        listsurfaceinspection.add("Monitor (Touch Screen)");
        listsurfaceinspection.add("Motor / BLDC Motor");
        listsurfaceinspection.add("Mounting Bracket");
        listsurfaceinspection.add("Mouse / Joystick");
        listsurfaceinspection.add("Other Spare Parts ");
        listsurfaceinspection.add("PCB Board");
        listsurfaceinspection.add("Power Supply");


        listsurfaceinspection.add("Register Mark Sensor");
        listsurfaceinspection.add("Roller");
        listsurfaceinspection.add("Strobe / Halogen Bulb");
        listsurfaceinspection.add("Transformer");
        listsurfaceinspection.add("Traverse");
        listsurfaceinspection.add("Ultrasonic Sensor");
        listsurfaceinspection.add("Sensor");



        //web guiding list


        listwebguiding.add("Cable / Cork Tape / Timing Belt");
        listwebguiding.add("Control Panel");
        listwebguiding.add("Drive");
        listwebguiding.add("Encoder");
        listwebguiding.add("Flash");
        listwebguiding.add("HMI Monitor");
        listwebguiding.add("Infrared Sensor");
        listwebguiding.add("Keyboard / Keypad ");

        listwebguiding.add("LED / Lights / Illumination");
        listwebguiding.add("MHRM Sensor");
        listwebguiding.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listwebguiding.add("Monitor (Touch Screen)");
        listwebguiding.add("Motor / BLDC Motor");



        listwebguiding.add("Mounting Bracket");
        listwebguiding.add("Mouse / Joystick");
        listwebguiding.add("Other Spare Parts");
        listwebguiding.add("PCB Board");
        listwebguiding.add("Power Supply");
        listwebguiding.add("Roller");
        listwebguiding.add("Strobe / Halogen Bulb");
        listwebguiding.add("Transformer");
        listwebguiding.add("Traverse");
        listwebguiding.add("Ultrasonic Sensor");
        listwebguiding.add("Sensor");





        listwebguiding.add("Accuweb Edge Guide Actuator");
        listwebguiding.add("Accuweb Edge Guide Controller");
        listwebguiding.add("Accuweb Edge Guide Sensor");
        listwebguiding.add("BST Pro Touch");
        listwebguiding.add("CCD");
        listwebguiding.add("CCD Pro");
        listwebguiding.add("CLS Pro600");
        listwebguiding.add("COMMANDER For EKR 500 Plus");
        listwebguiding.add("Compact Guide DF 2 x 60 x 200 x 200");
        listwebguiding.add("Compact Guide DF 2 x 60 x 250 x 250");




        listwebguiding.add("Compact Guide DF 2 x 60 x 500 x 300");
        listwebguiding.add("ECO EMS 22B");
        listwebguiding.add("EKR 1500");
        listwebguiding.add("EKR 500 Plus- DIGITAL");
        listwebguiding.add("ekr 500 Supremus");
        listwebguiding.add("EKR CON100");
        listwebguiding.add("EKR Digicon");
        listwebguiding.add("EKR PROCOM 40");
        listwebguiding.add("EKR PROCOM 50");
        listwebguiding.add("EKR PROCOM 60");






        listwebguiding.add("EMS 10");
        listwebguiding.add("EMS 16B");
        listwebguiding.add("EMS 18");
        listwebguiding.add("EMS 19B");
        listwebguiding.add("EMS 21");
        listwebguiding.add("EMS 22");
        listwebguiding.add("EMS 23");
        listwebguiding.add("EMS 5");
        listwebguiding.add("EMS CG/24");
        listwebguiding.add("IR 2002/10");








        listwebguiding.add("IR 2005");
        listwebguiding.add("IR 2005/30");
        listwebguiding.add("IR 2011");
        listwebguiding.add("IR 2011/40");
        listwebguiding.add("IR 2011/70");
        listwebguiding.add("IR 2012");
        listwebguiding.add("IR 2012/125");
        listwebguiding.add("IR 2012/40");
        listwebguiding.add("IR 2012/40 VERSION F");
        listwebguiding.add("IR 2013B/50");







        listwebguiding.add("Slitting Blade");
        listwebguiding.add("Turn Bar");
        listwebguiding.add("US 2010");
        listwebguiding.add("US 2010/40");
        listwebguiding.add("US 2010/40_200 KHz, Sensing Range 8mm");
        listwebguiding.add("US 2010/70");
        listwebguiding.add("US 2013_40 KHz, Sensing Range 10mm");
        listwebguiding.add("US 2013B/50");



        //web tension control


        listwebtensioncontrol.add("Cable / Cork Tape / Timing Belt");
        listwebtensioncontrol.add("Control Panel");
        listwebtensioncontrol.add("Drive");
        listwebtensioncontrol.add("Encoder");
        listwebtensioncontrol.add("Flash");
        listwebtensioncontrol.add("HMI Monitor");
        listwebtensioncontrol.add("Infrared Sensor");
        listwebtensioncontrol.add("Keyboard / Keypad ");

        listwebtensioncontrol.add("LED / Lights / Illumination");
        listwebtensioncontrol.add("MHRM Sensor");
        listwebtensioncontrol.add("Monitor (TFT / LED / LCD / HD / UHD)");
        listwebtensioncontrol.add("Monitor (Touch Screen)");
        listwebtensioncontrol.add("Motor / BLDC Motor");



        listwebtensioncontrol.add("Mounting Bracket");
        listwebtensioncontrol.add("Mouse / Joystick");
        listwebtensioncontrol.add("Other Spare Parts");
        listwebtensioncontrol.add("PCB Board");
        listwebtensioncontrol.add("Power Supply");
        listwebtensioncontrol.add("Roller");
        listwebtensioncontrol.add("Strobe / Halogen Bulb");
        listwebtensioncontrol.add("Transformer");
        listwebtensioncontrol.add("Traverse");
        listwebtensioncontrol.add("Ultrasonic Sensor");
        listwebtensioncontrol.add("Sensor");



        listwebtensioncontrol.add("Brake Shoe/Pad");
        listwebtensioncontrol.add("Fan for Brake");
        listwebtensioncontrol.add("Renova Caliper Brake CX 250.2");
        listwebtensioncontrol.add("Renova Caliper Brake CX 250.3");
        listwebtensioncontrol.add("Renova Caliper Brake CX 250.4");
        listwebtensioncontrol.add("Renova Caliper Brake CX 250.5");
        listwebtensioncontrol.add("Renova Caliper Brake CX 250.6");
        listwebtensioncontrol.add("Renova Load Cell Sensorex CF 85.100.17");
        listwebtensioncontrol.add("Renova Load Cell Sensorex CF 85.100.25");
        listwebtensioncontrol.add("Renova Load Cell Sensorex CF 85.15.17");


        listwebtensioncontrol.add("Renova Load Cell Sensorex CF 85.50.17");
        listwebtensioncontrol.add("Renova Load Cell Sensorex CF 85.50.25");
        listwebtensioncontrol.add("Renova Turborex Brake TS 170");
        listwebtensioncontrol.add("Renova Turborex Brake TS 170 ");
        listwebtensioncontrol.add("Renova Turborex Brake TS 180");
        listwebtensioncontrol.add("Renova Turborex Brake TX 160.20K/STD00");
        listwebtensioncontrol.add("Renova Turborex Brake TX180.150.C/STD01");
        listwebtensioncontrol.add("Tension Control System (DTC + LC + E/P + CX BRAKE)");
        listwebtensioncontrol.add("Tension Control System (DTC + LC + E/P + TS 170)");
        listwebtensioncontrol.add("Tension Control System (DTC + LC + E/P + TS 180)");

//web video list

        listwebvideoinspection.add("Area-Scan Camera");
        listwebvideoinspection.add("Cable / Cork Tape / Timing Belt");
        listwebvideoinspection.add("Camera Lens Assembly");
        listwebvideoinspection.add("Control Panel");
        listwebvideoinspection.add("Drive");
        listwebvideoinspection.add("Encoder");
        listwebvideoinspection.add("Flash");



        listwebvideoinspection.add("HMI Monitor");
        listwebvideoinspection.add("Infrared Sensor");
        listwebvideoinspection.add("Keyboard / Keypad");
        listwebvideoinspection.add("LED / Lights / Illumination");
        listwebvideoinspection.add("Line-Scan Camera");
        listwebvideoinspection.add("MHRM Sensor");
        listwebvideoinspection.add("Monitor (TFT / LED / LCD / HD / UHD)");



        listwebvideoinspection.add("Monitor (Touch Screen)");
        listwebvideoinspection.add("Motor / BLDC Motor");
        listwebvideoinspection.add("Mounting Bracket");
        listwebvideoinspection.add("Mouse / Joystick");
        listwebvideoinspection.add("Other Spare Parts ");
        listwebvideoinspection.add("PCB Board");
        listwebvideoinspection.add("Power Supply");

        listwebvideoinspection.add(" Register Mark Sensor");

        listwebvideoinspection.add("Roller");
        listwebvideoinspection.add("Strobe / Halogen Bulb");
        listwebvideoinspection.add("Transformer");
        listwebvideoinspection.add("Traverse");
        listwebvideoinspection.add("Ultrasonic Sensor");

        listwebvideoinspection.add("X-Rite Sensor");

        listwebvideoinspection.add("Sensor");





        listwebvideoinspection.add("Automatic Colour Monitoring for SHS");
        listwebvideoinspection.add("POWERScope 4000 Motorized");
        listwebvideoinspection.add("POWERScope 5000 Manual");
        listwebvideoinspection.add("POWERScope 5000 Manual with Touch Monitor");
        listwebvideoinspection.add("POWERScope 5000 Manual with Viewing Monitor");


        listwebvideoinspection.add("POWERScope 5000 Manual with Viewing Monitor and Commander");
        listwebvideoinspection.add("POWERScope 5000 Motorized with Touch Monitor");
        listwebvideoinspection.add("POWERScope 5000 Motorized with Viewing Monitor ");
        listwebvideoinspection.add("Smart Register for SHS4000");
        listwebvideoinspection.add("Smart Register for SHS4100");


        listwebvideoinspection.add("SuperHandy Scan 4000 5x4");
        listwebvideoinspection.add("SuperHandy Scan 4000 9x7");
        listwebvideoinspection.add("SuperHandy Scan 4100 5x4 ");
        listwebvideoinspection.add("SuperHandy Scan 4100 9x7");
        listwebvideoinspection.add("SuperHandy Scan 4100_Dual Camera");


        String spinnerprocat = NewCall1.s1.getSelectedItem().toString();
        String spinnerprodesc = NewCall1.s3.getSelectedItem().toString();

        if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("EagleEye – 100% Web Viewing System"))

        {

            s4.setItems(listinspection);
            //NewCall2.s4.setAdapter(adapter2);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("Inline color measurement"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_Check - 100% Print Inspection System"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_Check - 100% Surface Inspection System"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_Check_ECO - 100% Print Inspection System"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_View - Web Viewing System"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_Workflow"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("iPQ_Workflow - Rewinder Control System"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("Premius"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("SHARK 4000"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("100% Print Inspection")&& spinnerprodesc.equals("WebVideo_Star"))
        {

         s4.setItems(listinspection);
         //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("2 DRIVE SYSTEM"))
        {

            s4.setItems(listautomation);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("Adhesive Mixer"))
        {

         s4.setItems(listautomation);
         //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("Adhesive Sensor"))
        {

            s4.setItems(listautomation);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("Automation"))
        {

            s4.setItems(listautomation);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("MDS for Solventless Lami.M/C with Integrated Adhesive System"))
        {

            s4.setItems(listautomation);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Automation")&& spinnerprodesc.equals("RMC for Auto filling system for Alpha Mix"))
        {

            s4.setItems(listautomation);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Defect Detection System")&& spinnerprodesc.equals("SHARK 4000 LEX - 100% Print Defect Detection System"))
        {

            s4.setItems(listdefectdetsystem);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Defect Detection System")&& spinnerprodesc.equals("TubeScan Digital Strobe- Print Inspection System"))
        {

            s4.setItems(listdefectdetsystem);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Defect Detection System")&& spinnerprodesc.equals("TubeScan Eagle View - Print Inspection System"))
        {

            s4.setItems(listdefectdetsystem);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Density and thickness measurement")&& spinnerprodesc.equals("BST ProControl Basis Weight Measurement System"))
        {

            s4.setItems(listdensitythickness);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Mirror Image Registration")&& spinnerprodesc.equals("Mirror Image Registration"))
        {

            s4.setItems(listmirrorimagereg);
            //NewCall2.s4.setAdapter(adapter4);
        }






        else if (spinnerprocat.equals("Register and Viscosity Control")&& spinnerprodesc.equals("CRS10K \"EYE TOUCH\" - Register Control System"))
        {

            s4.setItems(listregisterandviscocity);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Register and Viscosity Control")&& spinnerprodesc.equals("SELECUT 9000 - Cutoff Control System"))
        {

            s4.setItems(listregisterandviscocity);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Register and Viscosity Control")&& spinnerprodesc.equals("SELECUT 9001 - Cutoff Control System"))
        {

            s4.setItems(listregisterandviscocity);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Register and Viscosity Control")&& spinnerprodesc.equals("SELEVISCO 9000 - Viscosity Control System"))
        {

            s4.setItems(listregisterandviscocity);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("AR 4000 - Register Control System"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("ARC_18 - Register Control System_ELS"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("ARC_18 - Register Control System_MLS"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("CIPCON Software"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("Insetter Control"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("Regi_Star 20"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Register Control (eltromat)")&& spinnerprodesc.equals("Sincon_Star"))
        {

            s4.setItems(listregistercotrol);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Special Purpose Machine")&& spinnerprodesc.equals("Splice Master"))
        {

            s4.setItems(listspecialpurposemachine);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Special Purpose Machine")&& spinnerprodesc.equals("SPM - Special Purpose Machinery"))
        {

            s4.setItems(listspecialpurposemachine);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Surface Inspection")&& spinnerprodesc.equals("WINTRISS - Web Ranger - Surface Inspection System"))
        {

            s4.setItems(listsurfaceinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("4 Roll Opto Electronic Web Guide Frame"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("DF Top and Bottom Frame Guide"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Ink Temprature Stabiliser"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Line/Edge Guide System"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Line/Edge Web Guide Components"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Opto Electronic Cutter Guide System"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Opto Electronic MASTER / SLAVE Guiding System"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Opto Electronic Web Guide Components"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Guiding")&& spinnerprodesc.equals("Opto Electronic Web Guide System"))
        {

            s4.setItems(listwebguiding);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Digital Tension Controller"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Dynaspede Tension Control System"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("ISOMATIC Seleten"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Magnetic Brake"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Powder Brake"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Renova Caliper Brake"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }


        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Renova Turborex Brake"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Roll Pusher"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }





        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Safety Chuck"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("T One Controller"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Tension Control")&& spinnerprodesc.equals("Tension Control System"))
        {

            s4.setItems(listwebtensioncontrol);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Video Inspection")&& spinnerprodesc.equals("POWERScope 3000"))
        {

            s4.setItems(listwebvideoinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Web Video Inspection")&& spinnerprodesc.equals("POWERScope 4000"))
        {

            s4.setItems(listwebvideoinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }

        else if (spinnerprocat.equals("Web Video Inspection")&& spinnerprodesc.equals("POWERScope 5000"))
        {

            s4.setItems(listwebvideoinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }



        else if (spinnerprocat.equals("Web Video Inspection")&& spinnerprodesc.equals("SuperHandy Scan 4000"))
        {

            s4.setItems(listwebvideoinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }




        else if (spinnerprocat.equals("Web Video Inspection")&& spinnerprodesc.equals("SuperHandy Scan 4100"))
        {

            s4.setItems(listwebvideoinspection);
            //NewCall2.s4.setAdapter(adapter4);
        }
        //set items to spinner from list
        //s4.setItems(listinspection);
        //Toast.makeText(NewCall2.this, "Selected : " + s4.getSelectedItemsAsString() , Toast.LENGTH_SHORT).show();

        username=(TextView)findViewById(R.id.username) ;
        mAuth = FirebaseAuth.getInstance();



        if(mAuth.getCurrentUser() == null)
        {
            //User NOT logged In
            this.finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


        //Fetch the Display name of current User
        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LOGGED", "FirebaseUser: " + user);

        if (user != null) {
            username.setText("" + user.getDisplayName());
            LoginActivity.LoggedIn_User_Email =user.getDisplayName();
        }




        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                        break;


                    case R.id.notification:
                        Intent j=new Intent(getApplicationContext(),PendingCallAttend.class);
                        startActivity(j);
                        break;

                    case R.id.visits:
                        Intent k=new Intent(getApplicationContext(),CallsToAttend.class);
                        startActivity(k);
                        break;

                  /*  case R.id.visits:
                        Intent j=new Intent(getApplicationContext(),ViewProfile.class);
                        startActivity(j);
                        break;*/
                }
                return true;
            }
        }
        );


       /* final ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(
                this, R.array.tag_arraysup0, android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adapter0);

        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });*/

  //s1 = (Spinner) findViewById(R.id.s1);


       /* final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tag_arrays1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);*/






        e1=(EditText)findViewById(R.id.e1);
       // e2=(EditText)findViewById(R.id.e2);
        //e3=(EditText)findViewById(R.id.e3);
        mDisplayTime = (TextView) findViewById(R.id.e4);
        mDisplayTime.setText("Select Time");
        mDisplayDate = (TextView) findViewById(R.id.e5);
        mDisplayDate.setText("Select Date");
        mReschdeuledDate = (TextView) findViewById(R.id.e6);
        b1=(Button)findViewById(R.id.b1);
         //step2
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

     // String check= s1.getText().toString();
        final String time = mDisplayTime.getText().toString();
        final String date = mDisplayDate.getText().toString();


        final String rdate = mReschdeuledDate.getText().toString();








       /* s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( getBaseContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString("spinner",s1.getSelectedItem().toString());

                String spinner=PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext())
                        .getString("spinner","");


                for(int i=0;i<5;i++)
                    if(spinner.equals(s1.getItemAtPosition(i).toString())){
                        s1.setSelection(i);
                        break;
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });*/





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //String spinnerValue1 = s4.getSelectedItem().toString();
                String displayDate=mDisplayDate.getText().toString();
                String displayRDate=mReschdeuledDate.getText().toString();
                String displayTime=mDisplayTime.getText().toString();


                if(e1.getText().toString().trim().length()==0)
                {
                    e1.setError("Please fill the details");
                    e1.requestFocus();
                }

               /* else if (spinnerValue1.equals("Select"))

                {
                    Toast.makeText(NewCall2.this, "Select at least one product name", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }*/
                else if (displayDate.equals("Enter Date"))

                {

                    Toast.makeText(NewCall2.this, "Select Call attending Date", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }


               /* else if (displayRDate.equals("Enter Date"))

                {

                    Toast.makeText(NewCall2.this, "Select Call Rescheduled Date", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }*/

                else if (displayTime.equals("Select Time"))

                {

                    Toast.makeText(NewCall2.this, "Select Engineer's In-Time", Toast.LENGTH_SHORT).show();
                    //NewCall2.s4.setAdapter(adapter2);
                }
                else{

                      //save the pserial
                    /*String pserial = e1.getText().toString();
                    mEditor.putString(getString(R.string.pserial), pserial);
                    mEditor.commit();







                    String time =mDisplayTime.getText().toString();
                     mEditor.putString(getString(R.string.time), time);
                    mEditor.commit();



                    String date = mDisplayDate.getText().toString();
                    mEditor.putString(getString(R.string.attenddate), date);
                    mEditor.commit();*/



                    String date = mDisplayDate.getText().toString( );
                    String rdate = mReschdeuledDate.getText().toString( );


                    Intent i=new Intent(NewCall2.this,NewCall3.class);
                    startActivity(i);

                }
            }
        }

        );

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewCall2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };





        mReschdeuledDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewCall2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mReschdeuledDate.setText(date);
            }
        };

       /* mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewCall2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });



        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };*/

 mDisplayTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minutes = cal.get(Calendar.MINUTE);


                    picker = new TimePickerDialog(NewCall2.this,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                    mDisplayTime.setText(sHour + ":" + sMinute);
                                }
                            }, hour, minutes, true);


                    picker.show();


                }

            });



    }

    private void checkSharedPreferences() {


        String pserial = mPreferences.getString(getString(R.string.pserial), "");
        String nature = mPreferences.getString(getString(R.string.nature), "");
        String details = mPreferences.getString(getString(R.string.details), "");
        String spinner = mPreferences.getString(getString(R.string.spinner), "");
        String time = mPreferences.getString(getString(R.string.time), "");
        String date = mPreferences.getString(getString(R.string.attenddate), "");
        mDisplayTime.setText(time);
        mDisplayDate.setText(date);
       // s4.setSelection(mPreferences.getInt("spinnerSelection4",0));







   //s1.();

        e1.setText(pserial);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        // int profile=item.getItemId();


        //signout function
        switch (id)
        {
            case R.id.signout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }



        return true;






    }


}

