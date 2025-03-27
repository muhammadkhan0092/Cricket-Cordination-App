package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentForgetPageDirections private constructor() {
  public companion object {
    public fun actionFragmentForgetPage3ToFragmentNewPasward(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentForgetPage3_to_fragmentNewPasward)

    public fun actionFragmentForgetPage3ToFragmentLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentForgetPage3_to_fragmentLogin)
  }
}
