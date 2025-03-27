package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentLoginDirections private constructor() {
  private data class ActionFragmentLoginToFragmentReg(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentLogin_to_fragmentReg

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentLoginToFragmentReg(type: String): NavDirections =
        ActionFragmentLoginToFragmentReg(type)

    public fun actionFragmentLoginToFragmentIntroduction(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentIntroduction)

    public fun actionFragmentLoginToFragmentForgetPage3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentForgetPage3)
  }
}
