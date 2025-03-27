package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentRegDirections private constructor() {
  public companion object {
    public fun actionFragmentRegToFragmentLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReg_to_fragmentLogin)

    public fun actionFragmentRegToFragmentLogin2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReg_to_fragmentLogin2)
  }
}
