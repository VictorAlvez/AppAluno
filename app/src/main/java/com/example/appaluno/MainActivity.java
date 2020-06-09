package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("AppAlunos", MODE_PRIVATE, null);

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Bob', 'Bob@gmail.com', '4999-5888')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Mark', 'Mark@hotmail.com', '3888-4777')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Victor', 'Victor@gmail.com', '2777-3666')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Joly', 'Joly@hotmail.com', '1666-2555')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Brad', 'Brad@gmail.com', '0555-1444')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Lara', 'Lara@hotmail.com', '9444-0333')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Simone', 'Simone@gmail.com', '8333-9222')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Mary', 'Mary@hotmail.com', '7222-8111')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Carrie', 'Carrie@gmail.com', '6111-7333')");
            bancoDados.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Charles', 'Charles@hotmail.com', '5000-6222')");

            Cursor cursor = bancoDados.rawQuery("SELECT nome, email, telefone FROM tbAluno", null);

            int IndiceNome = cursor.getColumnIndex("nome");
            int IndiceEmail = cursor.getColumnIndex("email");
            int IndicePhone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();
            while (cursor != null){
                Log.i("RESULTADO - nome: ", cursor.getString(IndiceNome));
                Log.i("RESULTADO - email: ", cursor.getString(IndiceEmail));
                Log.i("RESULTADO - telefone: ", cursor.getString(IndicePhone));
                cursor.moveToNext();





            }



        }catch (Exception e){
            e.printStackTrace();


        }
    }
}