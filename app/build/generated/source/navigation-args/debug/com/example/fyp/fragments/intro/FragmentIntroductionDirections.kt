package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentIntroductionDirections private constructor() {
  private data class ActionFragmentIntroductionToFragmentReg(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentIntroduction_to_fragmentReg

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  private data class ActionFragmentIntroductionToFragmentLogin(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentIntroduction_to_fragmentLogin

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  private data class ActionFragmentIntroductionToFragmentRegsponser(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentIntroduction_to_fragmentRegsponser

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentIntroductionToFragmentReg(type: String): NavDirections =
        ActionFragmentIntroductionToFragmentReg(type)

    public fun actionFragmentIntroductionToFragmentLogin(type: String): NavDirections =
        ActionFragmentIntroductionToFragmentLogin(type)

    public fun actionFragmentIntroductionToFragmentRegsponser(type: String): NavDirections =
        ActionFragmentIntroductionToFragmentRegsponser(type)
  }
}
