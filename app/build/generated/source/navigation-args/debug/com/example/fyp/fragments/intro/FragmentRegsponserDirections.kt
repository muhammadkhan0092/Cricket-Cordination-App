package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentRegsponserDirections private constructor() {
  public companion object {
    public fun actionFragmentRegsponserToFragmentLoginsponser(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentRegsponser_to_fragmentLoginsponser)
  }
}
