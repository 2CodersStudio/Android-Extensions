# Android-Extensions

[![Release](https://jitpack.io/v/2CodersStudio/Android-Extensions.svg)](https://jitpack.io/#2CodersStudio/Android-Extensions)

### Installation

1. Add in your root build.gradle file:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2. Add the dependency:

```gradle
	dependencies {
	        implementation 'com.github.2CodersStudio:Android-Extensions:v0.1'
	}
```

### Available extensions
* [Animation](#animation-extensions)
* [Fragment](#fragment-extensions)
* [Image](#image-extensions)
* [String](#string-extensions)

## Animation extensions
Using AppCompatActivity:

- `fadeIn(duration : Long = 1000)` Fade in a view from 0 to 1, duration by default is 1000.
- `fadeOut(finalVisibility: Int = View.INVISIBLE, duration : Long = 1000)` Fade outs a view from 0 to 1, duration by default is 1000, the final visibility by default is set to View.INVISIBLE.
- `startBounce()` Starts a bounce animation for any view, must be used with `endBounce()`.
- `endBounce()` Ends a bounce animation for any view, must be used with `startBounce()`.
- `replaceTextWithFade(newText : String, duration : Long = 1000)` Replaces a text inside a textview with a fadeIn - fadeOut animation.
- `fadeOutExitAnim()` Fade out animation transition for activity.
- `fadeInEnterAnim()` Fade in animation transition for activity.
- `topToBotExitAnimation()` Top to bot exit animation transition for activity.
- `botToTopEnterAnimation8)` Bot to top enter animation transition for activity.
- `rightToLeftEnterAnimation()` Right to left enter animation transition for activity.
- `leftToRightExitAnimation()` Left to right exit animation transition for activity.

## Fragment extensions
- `AppCompatActivity.addFragment(fragment: Fragment, containerId: Int)` Adds a fragment into the container.
- `AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int)` Replace the fragment in the container.
- `AppCompatActivity.withParcelable(item: Any, key : String): Fragment` Adds a parcelable object to the desired fragment.

## Image extensions
- `Activity.scaleImageFromScrensize(image: ImageView, percentage: Float = 0.5f)` scales the desired imageView in a screen percentage, the default percentage is 50%
- `getScreenHeight(): Int` returns the device screen height
- `getScreenWidth(): Int` returns the device screen width
## String extensions
- `isValidEmail(): Boolean` returns true or false depending if the value is an email, regex from http://emailregex.com/
- `isValidPassword(): Boolean` returns true or false if the value is a correct password, containing at least 8 characters, and at least one number.
- `encrypt(): String` returns the value encrypted by Base64
- `decrypt(): String` returns the value decrypted by Base64
- `isValidUsername(type : UsernameType = UsernameType.ALPHANUMERIC): Boolean`returns true if the user matches the pre-defined validations for the desired case, the case is defined by UsernameType enum, defining CHARACTER, ALPHANUMERIC and NUMERIC. The default value for username validation is ALPHANUMERIC