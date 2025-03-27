package com.example.fyp.fragments.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentProfileDirections private constructor() {
  public companion object {
    public fun actionFragmentProfile2ToFragmentProfileopen(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentProfile2_to_fragmentProfileopen)
  }
}
