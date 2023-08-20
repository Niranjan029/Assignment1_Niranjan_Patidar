package com.example.assignment1_niranjan_patidar


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1_niranjan_patidar.api.FacilitiesApi
import com.example.assignment1_niranjan_patidar.api.RetrofitHelper
import com.example.assignment1_niranjan_patidar.repository.FacilityRepository
import com.example.assignment1_niranjan_patidar.ui.theme.Assignment1_Niranjan_PatidarTheme
import com.example.assignment1_niranjan_patidar.viewModels.MainViewModel
import com.example.assignment1_niranjan_patidar.viewModels.MainViewModelFactory
lateinit var mainViewModel: MainViewModel
lateinit var  apiservice:FacilitiesApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         apiservice = RetrofitHelper.getInstance().create(FacilitiesApi::class.java)
        val repository = FacilityRepository(apiservice)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.facilities.observe(
            this
        ) {
            Log.i("facility", it.facilities.toString())
        }

        setContent {
            Assignment1_Niranjan_PatidarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    createForm( "User preferences")
                }
            }
        }
    }
}


@SuppressLint("MutableCollectionMutableState")
@Composable
fun createForm(name: String) {
    var selectedCheckboxIndex1 by remember { mutableStateOf(-1) }
    var selectedCheckboxIndex2 by remember { mutableStateOf(-1) }
    var selectedCheckboxIndex3 by remember { mutableStateOf(-1) }

    val checkboxOptions1 = listOf("Option 0", "Option 1", "Option 2", "Option 3")
    val checkboxOptions2 = listOf("Option 0", "Option 1")
    val checkboxOptions3 = listOf("Option 0", "Option 1", "Option 2")
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),

        ){
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$name",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
                .padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Property Type",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, top = 10.dp)
        )
        checkboxOptions1.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .clickable {
                        selectedCheckboxIndex1 = index
                    }
                    .height(40.dp)
            ) {
                RadioButton(
                    selected = selectedCheckboxIndex1 == index,
                    onClick = { selectedCheckboxIndex1 = index }
                )
                if (index == 0)
                    Text(
                        "Apartment",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else if (index == 1)
                    Text(
                        "Condo",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else if (index == 2)
                    Text(
                        "Boat House",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else
                    Text(
                        "Land",
                        modifier = Modifier.padding(top = 8.dp)
                    )
            }

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Number of Rooms",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, top = 10.dp)
        )
        checkboxOptions2.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .clickable {
                        selectedCheckboxIndex2 = index
                    }
                    .height(40.dp)
            )
            {
                RadioButton(
                    selected = selectedCheckboxIndex2 == index,
                    onClick = { selectedCheckboxIndex2 = index })
                if (index == 0)
                    Text(
                        "1 to 3 Rooms",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else
                    Text(
                        "No Rooms",
                        modifier = Modifier.padding(top = 8.dp)
                    )
            }
        }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Other Facilities",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, top = 10.dp),

                )
            Spacer(modifier = Modifier.height(8.dp))
        checkboxOptions3.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .clickable {
                        selectedCheckboxIndex3 = index
                    }
                    .height(40.dp)
            ) {
                RadioButton(
                    selected = selectedCheckboxIndex3 == index,
                    onClick = { selectedCheckboxIndex3 = index }
                )
                if (index == 0)
                    Text(
                        "Swimming pool",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else if (index == 1)
                    Text(
                        "Garden Area",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                else
                    Text(
                        "Garage",
                        modifier = Modifier.padding(top = 8.dp)
                    )
            }}
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Button(
                    onClick = {
                        Toast.makeText(context, "Hello mr programmer", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .height(38.dp)
                        .padding(start = 50.dp)
                ) {
                    Text(text = "Save")
                }
                Button(
                    onClick = {
                        Toast.makeText(context, "Reset button", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .height(38.dp)
                        .padding(start = 50.dp)
                ) {
                    Text(text = "Reset")
                }
            }
        }

    }
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Assignment1_Niranjan_PatidarTheme {
        createForm("User preferences")
    }
}