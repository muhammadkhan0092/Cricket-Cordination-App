package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentRegDirections private constructor() {
  private data class ActionFragmentRegToFragmentLogin(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentReg_to_fragmentLogin

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  private data class ActionFragmentRegToFragmentLogin2(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentReg_to_fragmentLogin2

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentRegToFragmentLogin(type: String): NavDirections =
        ActionFragmentRegToFragmentLogin(type)

    public fun actionFragmentRegToFragmentLogin2(type: String): NavDirections =
        ActionFragmentRegToFragmentLogin2(type)
  }
}
