package com.example.fyp.fragments.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R

public class FragmentTournamentDirections private constructor() {
  public companion object {
    public fun actionFragmentTournamentToFragmentLogin3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentTournament_to_fragmentLogin3)

    public fun actionFragmentTournamentToFragmentRGround(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentTournament_to_fragmentRGround)
  }
}
