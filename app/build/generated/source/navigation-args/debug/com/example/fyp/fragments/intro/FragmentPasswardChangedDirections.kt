package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentPasswardChangedDirections private constructor() {
  public companion object {
    public fun actionFragmentPasswardChangedToFragmentLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPasswardChanged_to_fragmentLogin)

    public fun actionFragmentPasswardChangedToFragmentLoginsponser(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPasswardChanged_to_fragmentLoginsponser)

    public fun actionFragmentPasswardChangedToFragmentLoginsponser2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPasswardChanged_to_fragmentLoginsponser2)
  }
}
