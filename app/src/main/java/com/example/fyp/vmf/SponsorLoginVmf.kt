package com.example.fyp.vmf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fyp.vm.SignUpViewModel
import com.example.fyp.vm.SponsorLoginVm
import com.example.fyp.vm.SponsorSignUpVm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class SponsorLoginVmf(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) :ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SponsorLoginVm(firebaseAuth,firestore) as T
    }
}