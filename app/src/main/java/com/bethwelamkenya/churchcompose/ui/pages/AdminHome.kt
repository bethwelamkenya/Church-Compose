package com.bethwelamkenya.churchcompose.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bethwelamkenya.churchcompose.R
import com.bethwelamkenya.churchcompose.ui.theme.*

@Composable
@Preview
fun AdminHomePage(){
    Box(modifier = Modifier
        .background(MainDark)
        .fillMaxSize()){
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(top = 10.dp, start = 10.dp, end = 10.dp))){
            ToolBar("Bethwel", " not")
//            AdminMainPage()
            AddMemberPage()
        }
    }
}

@Composable
fun ToolBar(name: String = "Admin", status: String = "") {
    var query by remember { mutableStateOf("") }
    val searchBarSize = 50.dp
    Row(modifier = Modifier
        .fillMaxWidth()
        .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge)
        .background(MainDark)
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.wrapContentWidth()) {
            Text(text = "Hi $name", color = TextWhite, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = "You are$status connected", color = Color.Gray, style = MaterialTheme.typography.titleSmall, fontStyle = FontStyle.Italic)
        }
        Row(modifier = Modifier
            .background(Color.Transparent)
            .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically) {
//            DockedSearchBar(query = query, onQueryChange = {query = it}, onSearch = {query = it}, active = false, onActiveChange = {
//                searchBarSize = if (it){
//                    200.dp
//                } else{
//                    50.dp
//                }
//            }) {
//            }
            Icon(painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                modifier = Modifier.size(28.dp),
                tint = Pink80
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(painter = painterResource(id = R.drawable.contacts),
                contentDescription = "Search Icon",
                modifier = Modifier.size(28.dp),
                tint = Pink80
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(painter = painterResource(id = R.drawable.more_vert),
                contentDescription = "Show More",
                modifier = Modifier.size(28.dp),
                tint = Pink80
            )
        }
    }
}

@Composable
fun AdminMainPage(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top) {
        Column(modifier = Modifier.fillMaxWidth(0.45F)) {
            Button(onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(75.dp)
                    .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge),
                colors = ButtonDefaults.buttonColors(containerColor = Main)
            ) {
                Icon(painter = painterResource(id = R.drawable.add_user_male), contentDescription = "Add Member",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Add Member", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(75.dp)
                    .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge),
                colors = ButtonDefaults.buttonColors(containerColor = Main)
            ) {
                Icon(painter = painterResource(id = R.drawable.user_menu_male), contentDescription = "Attendances",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Attendance", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(75.dp)
                    .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge),
                colors = ButtonDefaults.buttonColors(containerColor = Main)
            ) {
                Icon(painter = painterResource(id = R.drawable.admin_settings_male), contentDescription = "Account",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Account", style = MaterialTheme.typography.titleMedium)
            }
        }
        Column(modifier = Modifier.fillMaxWidth(0.9F)) {
            Button(onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(75.dp)
                    .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge),
                colors = ButtonDefaults.buttonColors(containerColor = Main)
            ) {
                Icon(painter = painterResource(id = R.drawable.group), contentDescription = "Members",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Members",  style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(75.dp)
                    .shadow(elevation = 5.dp, shape = ShapeDefaults.ExtraLarge),
                colors = ButtonDefaults.buttonColors(containerColor = Main)
            ) {
                Icon(painter = painterResource(id = R.drawable.user_menu_male), contentDescription = "Specific attendances",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Specific",  style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMemberPage() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var regNo by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var school by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var residence by remember { mutableStateOf("") }
    val focusRequesters = List(8) { FocusRequester() }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Name", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = name, onValueChange = {name = it},
                    label = { Text(text = "Name", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[0])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[1].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Email", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = email, onValueChange = {email = it},
                    label = { Text(text = "Email", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[1])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[2].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Registration Number", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = regNo, onValueChange = {regNo = it},
                    label = { Text(text = "Registration Number", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[2])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[3].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Mobile Number", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = number, onValueChange = {number = it},
                    label = { Text(text = "Mobile Number", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[3])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Phone),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[4].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "School", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = school, onValueChange = {school = it},
                    label = { Text(text = "School", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[4])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[5].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Year", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = year, onValueChange = {year = it},
                    label = { Text(text = "Year", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[5])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[6].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Department", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = department, onValueChange = {department = it},
                    label = { Text(text = "Department", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[6])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[7].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Residence", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = residence, onValueChange = {residence = it},
                    label = { Text(text = "Residence", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[7])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusRequesters[7].freeFocus()}, onGo = { focusRequesters[7].freeFocus()}),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.height(75.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Main)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.add_user_male), contentDescription = "Add User", modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Add Member", style = MaterialTheme.typography.titleMedium)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.height(75.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Main)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.delete_sign), contentDescription = "Cancel", modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Cancel", style = MaterialTheme.typography.titleMedium)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMemberPage(
    passid: Long = 0L,
    passname: String = "",
    passemail: String = "",
    passregNo: String = "",
    passnumber: Long = 712345678L,
    passchool: String = "",
    passyear: Int = 0,
    passdepartment: String = "",
    passresidence: String = ""
) {
    val schools = arrayOf("Engineering", "Education", "Science", "Arts", "Business", "Law", "Medicine", "Aerospace", "Community")
    val departments = arrayOf("Media", "Keyboardist", "Worshipper", "Usher", "Technician", "Intercessor",
        "Security", "Protocol", "Sanitation", "Violinist", "Pastor", "Bishop", "None")
    val years = arrayOf("Community", "One", "Two", "Three", "Four", "Five")
    var id by remember { mutableStateOf(passid.toString()) }
    var name by remember { mutableStateOf(passname) }
    var email by remember { mutableStateOf(passemail) }
    var regNo by remember { mutableStateOf(passregNo) }
    var number by remember { mutableStateOf(passnumber.toString()) }
    var school by remember { mutableStateOf(passchool) }
    var year by remember { mutableStateOf(years[passyear]) }
    var department by remember { mutableStateOf(passdepartment) }
    var residence by remember { mutableStateOf(passresidence) }
    val focusRequesters = List(8) { FocusRequester() }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "ID", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = id, onValueChange = {id = it},
                    label = { Text(text = "ID", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .align(Alignment.CenterHorizontally),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Name", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = name, onValueChange = {name = it},
                    label = { Text(text = "Name", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[0])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[1].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Email", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = email, onValueChange = {email = it},
                    label = { Text(text = "Email", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[1])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[2].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Registration Number", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = regNo, onValueChange = {regNo = it},
                    label = { Text(text = "Registration Number", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[2])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[3].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Mobile Number", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = number, onValueChange = {number = it},
                    label = { Text(text = "Mobile Number", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[3])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Phone),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[4].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "School", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = school, onValueChange = {school = it},
                    label = { Text(text = "School", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[4])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[5].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Year", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = year, onValueChange = {year = it},
                    label = { Text(text = "Year", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[5])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[6].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Department", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = department, onValueChange = {department = it},
                    label = { Text(text = "Department", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[6])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { focusRequesters[7].requestFocus() }),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Residence", color = Color.LightGray, modifier = Modifier.offset(x = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = residence, onValueChange = {residence = it},
                    label = { Text(text = "Residence", color = Color.Gray)},
                    colors = TextFieldDefaults.textFieldColors(TextWhite, unfocusedTextColor = TextWhite, containerColor = Color.Transparent),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .focusRequester(focusRequesters[7])
                        .align(Alignment.CenterHorizontally),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusRequesters[7].freeFocus()}, onGo = { focusRequesters[7].freeFocus()}),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.height(75.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Main)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.edit_user_male), contentDescription = "Edit Member", modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Edit Member", style = MaterialTheme.typography.titleMedium)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.height(75.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Main)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.delete_sign), contentDescription = "Cancel", modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Cancel", style = MaterialTheme.typography.titleMedium)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}