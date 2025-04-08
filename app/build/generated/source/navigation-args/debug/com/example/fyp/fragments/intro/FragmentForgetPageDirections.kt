package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentForgetPageDirections private constructor() {
  private data class ActionFragmentForgetPage3ToFragmentLogin(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentForgetPage3_to_fragmentLogin

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentForgetPage3ToFragmentNewPasward(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentForgetPage3_to_fragmentNewPasward)

    public fun actionFragmentForgetPage3ToFragmentLogin(type: String): NavDirections =
        ActionFragmentForgetPage3ToFragmentLogin(type)
  }
}
