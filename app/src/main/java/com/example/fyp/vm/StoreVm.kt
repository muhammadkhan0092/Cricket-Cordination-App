package com.example.fyp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fyp.data.DataProduct
import com.example.fyp.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class StoreVm(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) : ViewModel() {


    private val _getProducts = MutableStateFlow<Resource<List<DataProduct>>>(Resource.Unspecified())
    val getUser : StateFlow<Resource<List<DataProduct>>> =  _getProducts.asStateFlow()





    fun getProducts(){
        firestore.collection("products")
            .get()
            .addOnSuccessListener {
                val data = it.toObjects(DataProduct::class.java)
                if(data!=null && data.size!=0){
                  viewModelScope.launch {
                      _getProducts.emit(Resource.Success(data))
                  }
                }
                else
                {
                    viewModelScope.launch {
                        _getProducts.emit(Resource.Error("No products"))
                    }
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getProducts.emit(Resource.Error(it.message.toString()))
                }
            }
    }




}