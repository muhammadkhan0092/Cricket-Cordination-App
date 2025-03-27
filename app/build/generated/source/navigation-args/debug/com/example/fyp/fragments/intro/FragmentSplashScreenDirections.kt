package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentSplashScreenDirections private constructor() {
  public companion object {
    public fun actionFragmentSplashScreenToFragmentIntroduction(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentSplashScreen_to_fragmentIntroduction)
  }
}
