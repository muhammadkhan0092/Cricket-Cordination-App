package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentNewPaswardDirections private constructor() {
  public companion object {
    public fun actionFragmentNewPaswardToFragmentPasswardChanged(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNewPasward_to_fragmentPasswardChanged)

    public fun actionFragmentNewPaswardToFragmentPasswardChanged2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNewPasward_to_fragmentPasswardChanged2)

    public fun actionFragmentNewPaswardToFragmentForgetPage3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNewPasward_to_fragmentForgetPage3)
  }
}
