package br.com.angelcomp.noteapp.feature_note.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import br.com.angelcomp.noteapp.ui.theme.NoteAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {

            }
        }
    }
}