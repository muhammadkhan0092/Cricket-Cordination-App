package com.example.fyp.fragments.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentStoreDirections private constructor() {
  public companion object {
    public fun actionFragmentStoreToFragmentPumaPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentStore_to_fragmentPumaPage)

    public fun actionFragmentStoreToFragmentNikePage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentStore_to_fragmentNikePage)

    public fun actionFragmentStoreToFragmentAdidasPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentStore_to_fragmentAdidasPage)

    public fun actionFragmentStoreToFragmentReebokPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentStore_to_fragmentReebokPage)
  }
}
