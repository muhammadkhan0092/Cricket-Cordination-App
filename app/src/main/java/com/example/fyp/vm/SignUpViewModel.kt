package com.example.fyp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fyp.data.User
import com.example.fyp.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SignUpViewModel( val firebaseAuth: FirebaseAuth,val firestore : FirebaseFirestore) : ViewModel() {

    private val _createUser = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val createUser : StateFlow<Resource<String>> = _createUser.asStateFlow()

    private val _getUser = MutableStateFlow<Resource<User>>(Resource.Unspecified())
    val getUser : StateFlow<Resource<User>> =  _getUser.asStateFlow()

    fun createUserWithEmaiLAndPass(user: User){
        firebaseAuth.createUserWithEmailAndPassword(user.email,user.pass)
            .addOnSuccessListener {
                val userid = it.user?.uid
                if(userid!=null){
                    user.id = userid
                    setUserData(user)
                }
            }
            .addOnFailureListener{
                viewModelScope.launch {
                    _createUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }

    fun setUserData(user: User){
        firestore.collection("player").document(user.id)
            .set(user)
            .addOnSuccessListener {
                viewModelScope.launch {
                    _createUser.emit(Resource.Success("SUCCESS"))
                }
            }.addOnFailureListener {
                viewModelScope.launch {
                    _createUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }

    fun getUser(){
        firestore.collection("player").whereEqualTo("id",FirebaseAuth.getInstance().uid)
            .get()
            .addOnSuccessListener {
                val data = it.toObjects(User::class.java)
                val user = data.first()
                if(user!=null){
                    viewModelScope.launch {
                        _getUser.emit(Resource.Success(user))
                    }
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }


}