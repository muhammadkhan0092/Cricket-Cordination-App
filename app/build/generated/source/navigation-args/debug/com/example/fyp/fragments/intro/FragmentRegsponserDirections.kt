package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentRegsponserDirections private constructor() {
  private data class ActionFragmentRegsponserToFragmentLoginsponser(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentRegsponser_to_fragmentLoginsponser

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentRegsponserToFragmentLoginsponser(type: String): NavDirections =
        ActionFragmentRegsponserToFragmentLoginsponser(type)
  }
}
