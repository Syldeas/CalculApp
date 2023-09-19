package com.example.calculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private Button buttonAjouter;
    private Button buttonCalculer;
    private TextView textViewTotal;
    private TextView textViewMoyenne;

    private ArrayList<Double> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        buttonAjouter = findViewById(R.id.buttonAjouter);
        buttonCalculer = findViewById(R.id.buttonCalculer);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewMoyenne = findViewById(R.id.textViewMoyenne);

        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer la note saisie par l'utilisateur
                String noteStr = editTextNote.getText().toString();
                if (!noteStr.isEmpty()) {
                    // Convertir la note en nombre décimal
                    double note = Double.parseDouble(noteStr);
                    // Ajouter la note à la liste
                    notes.add(note);
                    // Effacer le champ de saisie
                    editTextNote.getText().clear();
                }
            }
        });

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculer le total des notes
                double total = 0;
                for (double note : notes) {
                    total += note;
                }
                // Calculer la moyenne des notes
                double moyenne = total / notes.size();

                // Afficher le total et la moyenne dans les TextViews
                textViewTotal.setText("Total: " + total);
                textViewMoyenne.setText("Moyenne: " + moyenne);
            }
        });
    }
}
