package id.sch.smktelkom_mlg.tugas01.xiirpl3004.aplikasihotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNomor;
    Button btOk;
    TextView tvHasil;
    Spinner spTipe;
    RadioButton rbM, rbBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextKtp);
        btOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        spTipe = (Spinner) findViewById(R.id.spinnerTipe);
        rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rbBM = (RadioButton) findViewById(R.id.radioButtonBM);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();

        String ket = "";
        if (rbM.isChecked()) {
            ket = rbM.getText().toString();
        } else if (rbBM.isChecked()) {
            ket = rbBM.getText().toString();
        } else {
            ket = "Anda belum memilih member";
        }

        if (isValid()) {
            tvHasil.setText("Nama : " + nama +
                    "\nNomor KTP : " + nomor +
                    "\nStatus : " + ket +
                    "\nTipe Kamar : " + spTipe.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String namaa = etNama.getText().toString();
        String nomorr = etNomor.getText().toString();

        if (namaa.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nomorr.isEmpty()) {
            etNomor.setError("Nomor KTP belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
            etNomor.setError(null);
        }

        return valid;
    }
}
