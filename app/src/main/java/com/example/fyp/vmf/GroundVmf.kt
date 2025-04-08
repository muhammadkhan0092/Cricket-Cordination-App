package com.example.fyp.vmf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fyp.vm.GroundVm
import com.example.fyp.vm.SponsorLoginVm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class GroundVmf(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) :ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroundVm(firebaseAuth,firestore) as T
    }
}