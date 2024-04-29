package com.example.chorddition

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // creates variables for button eventhandling
    private lateinit var checkPopup: Button
    private lateinit var instructionPopup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // links earlier variables to buttons in the .xml file using their id
        checkPopup = findViewById(R.id.checkButton)
        instructionPopup = findViewById(R.id.instructionButton)

        // creates lists containing basic chords in each respective key/scale
        val cChords = listOf("C", "Dm", "Em", "F", "G", "Am", "Bdim")
        val dChords = listOf("D", "Em", "F#m", "G", "A", "Bm", "C#")
        val gChords = listOf("G", "Am", "Bm", "C", "D", "Em", "F#mb5")

        // links the spinner widget in the .xml file to the .kt file
        val keyDrop = findViewById<Spinner>(R.id.keySelect)
        //sets items in the dropdown menu
        val keyItems = arrayOf("C", "D", "G")
        // sets a default value for the spinner when no user input is detected
        var selectedKey = keyItems.first()

        // if user selects from dropdown menu/changes the default value
        if (keyDrop != null) {
            // creates an adapter to link the layout, the spinner, and the dropdown items together
            val keyAdapter = ArrayAdapter( this, android.R.layout.simple_spinner_item, keyItems)
            // sets the adapter to the spinner variable linked to the widget in the .xml file
            keyDrop.adapter = keyAdapter

            // changes the default/selected item in the dropdown based on user input
            keyDrop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedKey = keyItems[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        // links the spinner widget in the .xml file to the .kt file
        val chordDrop1 = findViewById<Spinner>(R.id.chordSelect1)
        //sets items in the dropdown menu
        val chordItems1 = arrayOf("C", "C#", "Dm", "D", "Em", "F#m", "F#mb5", "F", "G", "Am", "A", "Bdim", "Bm")
        // sets a default value for the spinner when no user input is detected
        var selectedChord1 = chordItems1.first()

        // if user selects from dropdown menu/changes the default value
        if (chordDrop1 != null) {
            // creates an adapter to link the layout, the spinner, and the dropdown items together
            val chordAdapter1 = ArrayAdapter( this, android.R.layout.simple_spinner_item, chordItems1)
            // sets the adapter to the spinner variable linked to the widget in the .xml file
            chordDrop1.adapter = chordAdapter1

            // changes the default/selected item in the dropdown based on user input
            chordDrop1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedChord1 = chordItems1[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        // links the spinner widget in the .xml file to the .kt file
        val chordDrop2 = findViewById<Spinner>(R.id.chordSelect2)
        //sets items in the dropdown menu
        val chordItems2 = arrayOf("C", "C#", "Dm", "D", "Em", "F#m", "F#mb5", "F", "G", "Am", "A", "Bdim", "Bm")
        // sets a default value for the spinner when no user input is detected
        var selectedChord2 = chordItems2.first()

        // if user selects from dropdown menu/changes the default value
        if (chordDrop2 != null) {
            // creates an adapter to link the layout, the spinner, and the dropdown items together
            val chordAdapter2 = ArrayAdapter( this, android.R.layout.simple_spinner_item, chordItems2)
            // sets the adapter to the spinner variable linked to the widget in the .xml file
            chordDrop2.adapter = chordAdapter2

            // changes the default/selected item in the dropdown based on user input
            chordDrop2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    selectedChord2 = chordItems2[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        // applies on checkButton click (linked through the checkPopup variable)
        checkPopup.setOnClickListener {
            // if selected key is in position [0] or the item "C"
            if (selectedKey == keyItems[0]) {
                // code checks if selected values in chord dropdowns are in the earlier list for chords in the C Key
                if (selectedChord1 in cChords && selectedChord2 in cChords) {
                    // runs popup window function for harmonic
                    showHarmonicPopup()
                }

                // if chords are mismatched, run popup window function for dissonant
                else {
                    showDissonantPopup()
                }
            }

            // if selected key is in position [1] or the item "D"
            else if (selectedKey == keyItems[1]) {
                // code checks if selected values in chord dropdowns are in the earlier list for chords in the D Key
                if (selectedChord1 in dChords && selectedChord2 in dChords) {
                    // runs popup window function for harmonic
                    showHarmonicPopup()
                }

                // if chords are mismatched, run popup window function for dissonant
                else {
                    showDissonantPopup()
                }
            }

            // if selected key is in position [2] or the item "G"
            else {
                // code checks if selected values in chord dropdowns are in the earlier list for chords in the G Key
                if (selectedChord1 in gChords && selectedChord2 in gChords) {
                    // runs popup window function for harmonic
                    showHarmonicPopup()
                }

                // if chords are mismatched, run popup window function for dissonant
                else {
                    showDissonantPopup()
                }
            }
        }

        // applies on instructionButton click (linked through the instructionPopup variable)
        instructionPopup.setOnClickListener {
            // runs popup window function for instructions
            showInstructionPopup()
        }
    }

    // function for instruction popup window
    private fun showInstructionPopup() {
        //creates an inflater to show new layout on top of the original layout
        val instructionInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // sets inflater variable to the instructions popup .xml file
        val instructionPopupView = instructionInflater.inflate(R.layout.activity_instructions, null)

        // sets height and width for the popup window
        val instructionWidth =  1080
        val instructionHeight = 2220

        // creates the popup window by linking the inflater, height, and width variables together
        val instructionWindow = PopupWindow(instructionPopupView, instructionWidth, instructionHeight, true)
        instructionWindow.showAtLocation(instructionPopupView, Gravity.BOTTOM, 0, 0)

        // links button in the popup .xml file to the main activity .kt file
        val instructionClose = instructionPopupView.findViewById<Button>(R.id.instructionCloseButton)
        // closes the popup window on button click
        instructionClose.setOnClickListener {
            instructionWindow.dismiss()
        }
    }

    // function for harmonic popup window
    private fun showHarmonicPopup() {
        //creates an inflater to show new layout on top of the original layout
        val harmonicInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // sets inflater variable to the harmonic popup .xml file
        val harmonicPopupView = harmonicInflater.inflate(R.layout.activity_harmonic_popup, null)

        // sets height and width for the popup window
        val harmonicWidth =  1080
        val harmonicHeight = 450

        // creates the popup window by linking the inflater, height, and width variables together
        val harmonicWindow = PopupWindow(harmonicPopupView, harmonicWidth, harmonicHeight, true)
        harmonicWindow.showAtLocation(harmonicPopupView, Gravity.BOTTOM, 0, 0)

        // links button in the popup .xml file to the main activity .kt file
        val harmonicClose = harmonicPopupView.findViewById<Button>(R.id.harmonicCloseButton)
        // closes the popup window on button click
        harmonicClose.setOnClickListener {
            harmonicWindow.dismiss()
        }
    }

    //function for dissonant popup window
    private fun showDissonantPopup() {
        //creates an inflater to show new layout on top of the original layout
        val dissonantInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // sets the inflater to the dissonant popup .xml file
        val dissonantPopupView = dissonantInflater.inflate(R.layout.activity_dissonant_popup, null)

        // sets height and width for the popup window
        val dissonantWidth =  1080
        val dissonantHeight = 450

        // creates the popup window by linking the inflater, height, and width variables together
        val dissonantWindow = PopupWindow(dissonantPopupView, dissonantWidth, dissonantHeight, true)
        dissonantWindow.showAtLocation(dissonantPopupView, Gravity.BOTTOM, 0, 0)

        // links button in the popup .xml file to the main activity .kt file
        val dissonantClose = dissonantPopupView.findViewById<Button>(R.id.dissonantCloseButton)
        // closes the popup window on button click
        dissonantClose.setOnClickListener {
            dissonantWindow.dismiss()
        }
    }
}