package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentReebokPageDirections private constructor() {
  public companion object {
    public fun actionFragmentReebokPageToFragmentGigPage10(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReebokPage_to_fragmentGigPage10)

    public fun actionFragmentReebokPageToFragmentGigPage11(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReebokPage_to_fragmentGigPage11)

    public fun actionFragmentReebokPageToFragmentGigPage12(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReebokPage_to_fragmentGigPage12)
  }
}
