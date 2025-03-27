package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentAdidasPageDirections private constructor() {
  public companion object {
    public fun actionFragmentAdidasPageToFragmentGigPage7(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentAdidasPage_to_fragmentGigPage7)

    public fun actionFragmentAdidasPageToFragmentGigPage8(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentAdidasPage_to_fragmentGigPage8)

    public fun actionFragmentAdidasPageToFragmentGigPage9(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentAdidasPage_to_fragmentGigPage9)
  }
}
