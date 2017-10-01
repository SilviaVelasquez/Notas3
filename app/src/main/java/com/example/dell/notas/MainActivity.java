package com.example.dell.notas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity
{
    private EditText et1, et2, et3, et4, et5, et6, et7,et8, et9, et10, et11, et12;

    private TextView tv1, tv2, tv3,tv4,tv5, tv6, tv7, tv8, tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        et8 = (EditText) findViewById(R.id.et8);
        et9 = (EditText) findViewById(R.id.et9);
        et10 = (EditText) findViewById(R.id.et10);
        et11 = (EditText) findViewById(R.id.et11);
        et12 = (EditText) findViewById(R.id.et12);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);


        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(prefe.getString("n1","0"));
        et2.setText(prefe.getString("n2","0"));
        et3.setText(prefe.getString("n3","0"));
        et4.setText(prefe.getString("n4","0"));
        et5.setText(prefe.getString("n5","0"));
        et6.setText(prefe.getString("n6","0"));
        et7.setText(prefe.getString("n7","0"));
        et8.setText(prefe.getString("n8","0"));
        et9.setText(prefe.getString("n9","0"));
        et10.setText(prefe.getString("n10","0"));
        et11.setText(prefe.getString("n11","0"));
        et12.setText(prefe.getString("n12","0"));
        tv3.setText(prefe.getString("materia1",tv3.getText().toString()));
        tv5.setText(prefe.getString("materia2",tv5.getText().toString()));
        tv7.setText(prefe.getString("materia3",tv7.getText().toString()));
        tv9.setText(prefe.getString("materia4",tv9.getText().toString()));

    et1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            try {
                String nota1 = et1.getText().toString();
                String nota2 = et2.getText().toString();
                String nota3 = et3.getText().toString();
                double nro1 = parseDouble(nota1);
                double nro2 = parseDouble(nota2);
                double nro3 = parseDouble(nota3);
                if(nro1<=5) {
                double MateriaResult = (((nro1 + nro2) / 2 * 0.6) + nro3 * 0.4);
                double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                    SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("n1", et1.getText().toString());
                    editor.putString("n2", et2.getText().toString());
                    editor.putString("n3", et3.getText().toString());
                    editor.putString("materia1", tv3.getText().toString());
                    editor.commit();
                tv3.setText(resultado);
                }else
                {
                    Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                    toas.show();
                }

            } catch (Exception e) {
                if (et1.getText().toString().equals("Ingresar nota") || et2.getText().toString().equals("Ingresar nota") || et3.getText().toString().equals("Ingresar nota")) {
                    Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                    toast3.show();
                }
            }
        }
    });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et1.getText().toString();
                String nota2 = et2.getText().toString();
                String nota3 = et3.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro2<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n1", et1.getText().toString());
                        editor.putString("n2", et2.getText().toString());
                        editor.putString("n3", et3.getText().toString());
                        editor.putString("materia1", tv3.getText().toString());
                        editor.commit();
                tv3.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et1.getText().toString().equals("Ingresar nota") || et2.getText().toString().equals("Ingresar nota") || et3.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et1.getText().toString();
                String nota2 = et2.getText().toString();
                String nota3 = et3.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro3<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n1", et1.getText().toString());
                        editor.putString("n2", et2.getText().toString());
                        editor.putString("n3", et3.getText().toString());
                        editor.putString("materia1", tv3.getText().toString());
                        editor.commit();
                tv3.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et1.getText().toString().equals("Ingresar nota") || et2.getText().toString().equals("Ingresar nota") || et3.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et4.getText().toString();
                String nota2 = et5.getText().toString();
                String nota3 = et6.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro1<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n4", et4.getText().toString());
                        editor.putString("n5", et5.getText().toString());
                        editor.putString("n6", et6.getText().toString());
                        editor.putString("materia2", tv5.getText().toString());
                        editor.commit();
                tv5.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et4.getText().toString().equals("Ingresar nota") || et5.getText().toString().equals("Ingresar nota") || et6.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et4.getText().toString();
                String nota2 = et5.getText().toString();
                String nota3 = et6.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro2<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n4", et4.getText().toString());
                        editor.putString("n5", et5.getText().toString());
                        editor.putString("n6", et6.getText().toString());
                        editor.putString("materia2", tv5.getText().toString());
                        editor.commit();
                tv5.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et4.getText().toString().equals("Ingresar nota") || et5.getText().toString().equals("Ingresar nota") || et6.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et4.getText().toString();
                String nota2 = et5.getText().toString();
                String nota3 = et6.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro3<=5) {
                    double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n4", et4.getText().toString());
                        editor.putString("n5", et5.getText().toString());
                        editor.putString("n6", et6.getText().toString());
                        editor.putString("materia2", tv5.getText().toString());
                        editor.commit();
                tv5.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et4.getText().toString().equals("Ingresar nota") || et5.getText().toString().equals("Ingresar nota") || et6.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et7.getText().toString();
                String nota2 = et8.getText().toString();
                String nota3 = et9.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro1<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n7", et7.getText().toString());
                        editor.putString("n8", et8.getText().toString());
                        editor.putString("n9", et9.getText().toString());
                        editor.putString("materia3", tv7.getText().toString());
                        editor.commit();
                tv7.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et7.getText().toString().equals("Ingresar nota") || et8.getText().toString().equals("Ingresar nota") || et9.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et7.getText().toString();
                String nota2 = et8.getText().toString();
                String nota3 = et9.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro2<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n7", et7.getText().toString());
                        editor.putString("n8", et8.getText().toString());
                        editor.putString("n9", et9.getText().toString());
                        editor.putString("materia3", tv7.getText().toString());
                        editor.commit();
                tv7.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et7.getText().toString().equals("Ingresar nota") || et8.getText().toString().equals("Ingresar nota") || et9.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et7.getText().toString();
                String nota2 = et8.getText().toString();
                String nota3 = et9.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro3<=5) {
                        double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                        double nrl = (MateriaResult * 100) / 100;
                        String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n7", et7.getText().toString());
                        editor.putString("n8", et8.getText().toString());
                        editor.putString("n9", et9.getText().toString());
                        editor.putString("materia3", tv7.getText().toString());
                        editor.commit();
                tv7.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et7.getText().toString().equals("Ingresar nota") || et8.getText().toString().equals("Ingresar nota") || et9.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et10.getText().toString();
                String nota2 = et11.getText().toString();
                String nota3 = et12.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro1<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n10", et10.getText().toString());
                        editor.putString("n11", et11.getText().toString());
                        editor.putString("n12", et12.getText().toString());
                        editor.putString("materia4", tv9.getText().toString());
                        editor.commit();
                tv9.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et10.getText().toString().equals("Ingresar nota") || et11.getText().toString().equals("Ingresar nota") || et12.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et10.getText().toString();
                String nota2 = et11.getText().toString();
                String nota3 = et12.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro2<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n10", et10.getText().toString());
                        editor.putString("n11", et11.getText().toString());
                        editor.putString("n12", et12.getText().toString());
                        editor.putString("materia4", tv9.getText().toString());
                        editor.commit();
                tv9.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et10.getText().toString().equals("Ingresar nota") || et11.getText().toString().equals("Ingresar nota") || et12.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });
        et12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                String nota1 = et10.getText().toString();
                String nota2 = et11.getText().toString();
                String nota3 = et12.getText().toString();
                    double nro1 = parseDouble(nota1);
                    double nro2 = parseDouble(nota2);
                    double nro3 = parseDouble(nota3);
                    if(nro3<=5) {
                double MateriaResult = (((nro1+nro2)/2*0.6)+nro3*0.4);
                    double nrl = (MateriaResult * 100) / 100;
                String resultado = String.valueOf(MateriaResult);
                        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putString("n10", et10.getText().toString());
                        editor.putString("n11", et11.getText().toString());
                        editor.putString("n12", et12.getText().toString());
                        editor.putString("materia4", tv9.getText().toString());
                        editor.commit();
                tv9.setText(resultado);
                    }else
                    {
                        Toast toas = Toast.makeText(MainActivity.this, "no debe ser mayor a 5" + " ", Toast.LENGTH_LONG);
                        toas.show();
                    }
                } catch (Exception e) {
                    if (et10.getText().toString().equals("Ingresar nota") || et11.getText().toString().equals("Ingresar nota") || et12.getText().toString().equals("Ingresar nota")) {
                        Toast toast3 = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });

    }

    /**
     * el presente metodo realiza el caulo total de las cuatro materias
     * @param view
     */
    public void calcular(View view)
    {
        String valor1 = tv3.getText().toString();
        double nro1 = parseDouble(valor1);
        String valor2 = tv5.getText().toString();
        double nro2 = parseDouble(valor2);
        String valor3 = tv7.getText().toString();
        double nro3 = parseDouble(valor3);
        String valor4 = tv9.getText().toString();
        double nro4 =parseDouble(valor4);
        double calcularpromedio = ((nro1 + nro2 + nro3+ nro4) / 4);
        String total=String.valueOf(calcularpromedio);
        Toast toast1=Toast.makeText(this,"el promedio es"+total, Toast.LENGTH_LONG);
        toast1.show();
    }

    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }
}
