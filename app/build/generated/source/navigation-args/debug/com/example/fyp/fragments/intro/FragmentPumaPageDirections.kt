package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentPumaPageDirections private constructor() {
  public companion object {
    public fun actionFragmentPumaPageToFragmentGigPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPumaPage_to_fragmentGigPage)

    public fun actionFragmentPumaPageToFragmentGigPage2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPumaPage_to_fragmentGigPage2)

    public fun actionFragmentPumaPageToFragmentGigPage3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPumaPage_to_fragmentGigPage3)
  }
}
