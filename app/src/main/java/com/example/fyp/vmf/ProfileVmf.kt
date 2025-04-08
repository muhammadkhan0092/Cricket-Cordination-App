package com.example.fyp.vmf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fyp.vm.ProfileVm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ProfileVmf(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) :ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileVm(firebaseAuth,firestore) as T
    }
}