package com.example.fyp.fragments.intro

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class FragmentRegArgs(
  public val type: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("type", this.type)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("type", this.type)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FragmentRegArgs {
      bundle.setClassLoader(FragmentRegArgs::class.java.classLoader)
      val __type : String?
      if (bundle.containsKey("type")) {
        __type = bundle.getString("type")
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"type\" is missing and does not have an android:defaultValue")
      }
      return FragmentRegArgs(__type)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FragmentRegArgs {
      val __type : String?
      if (savedStateHandle.contains("type")) {
        __type = savedStateHandle["type"]
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"type\" is missing and does not have an android:defaultValue")
      }
      return FragmentRegArgs(__type)
    }
  }
}
