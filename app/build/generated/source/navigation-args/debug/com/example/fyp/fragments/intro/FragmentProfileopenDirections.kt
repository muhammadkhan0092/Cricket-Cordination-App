package com.example.fyp.fragments.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentProfileopenDirections private constructor() {
  public companion object {
    public fun actionFragmentProfileopenToFragmentProfile2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentProfileopen_to_fragmentProfile2)

    public fun actionFragmentProfileopenToFragmentIntroduction2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentProfileopen_to_fragmentIntroduction2)
  }
}
