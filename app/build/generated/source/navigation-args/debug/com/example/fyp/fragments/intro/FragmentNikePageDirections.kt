package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentNikePageDirections private constructor() {
  public companion object {
    public fun actionFragmentNikePageToFragmentGigPage4(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNikePage_to_fragmentGigPage4)

    public fun actionFragmentNikePageToFragmentGigPage5(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNikePage_to_fragmentGigPage5)

    public fun actionFragmentNikePageToFragmentGigPage6(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNikePage_to_fragmentGigPage6)
  }
}
