package com.example.fyp.fragments.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentHomeDirections private constructor() {
  public companion object {
    public fun actionFragmentHomeToFragmentPlayerProfileCheck(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentHome_to_fragmentPlayerProfileCheck)
  }
}
