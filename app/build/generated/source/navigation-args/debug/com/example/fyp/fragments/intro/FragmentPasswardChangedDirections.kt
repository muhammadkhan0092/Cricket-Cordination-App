package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.fyp.R
import kotlin.Int
import kotlin.String

public class FragmentPasswardChangedDirections private constructor() {
  private data class ActionFragmentPasswardChangedToFragmentLogin(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentPasswardChanged_to_fragmentLogin

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  private data class ActionFragmentPasswardChangedToFragmentLoginsponser(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentPasswardChanged_to_fragmentLoginsponser

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  private data class ActionFragmentPasswardChangedToFragmentLoginsponser2(
    public val type: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentPasswardChanged_to_fragmentLoginsponser2

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionFragmentPasswardChangedToFragmentLogin(type: String): NavDirections =
        ActionFragmentPasswardChangedToFragmentLogin(type)

    public fun actionFragmentPasswardChangedToFragmentLoginsponser(type: String): NavDirections =
        ActionFragmentPasswardChangedToFragmentLoginsponser(type)

    public fun actionFragmentPasswardChangedToFragmentLoginsponser2(type: String): NavDirections =
        ActionFragmentPasswardChangedToFragmentLoginsponser2(type)
  }
}
