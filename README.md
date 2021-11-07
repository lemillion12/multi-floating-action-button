# Multi Floating Action Button

[![](https://jitpack.io/v/lemillion12/multi-floating-action-button.svg)](https://jitpack.io/#lemillion12/multi-floating-action-button)

<img src="/demo/demo_1.gif" width="290" align="right" hspace="0" />

Android library providing an implementation of the [Material Design Floating Action Button Speed Dial](https://material.io/guidelines/components/buttons-floating-action-button.html#buttons-floating-action-button-transitions).

## Features
- [x] Main Floating Action Button expands into multiple Small Floating Action Buttons
- [x] Highly customizable (label, icon and background colors, themes support)
- [x] Easy to use

## How to use
### Gradle setup
#### Official releases
The library is available on JitPack. To add the dependency in your project:

Step 1. Add the JitPack repository to your root build.gradle at the end of repositories: 

```groovy
	allprojects {
        repositories { 
            //...
            maven { url 'https://jitpack.io' }
        }
    }
```
Step 2. Add the dependency entry (latest version on JitPack): [![](https://jitpack.io/v/lemillion12/multi-floating-action-button.svg)](https://jitpack.io/#lemillion12/multi-floating-action-button)

```groovy
    dependencies {
        implementation 'com.github.lemillion12:multi-floating-action-button:1.0.0'
    }
```

### Basic use
#### `Multi Floating Action Button`
Use the `MultiFloatingActionButton` constructor to create your composable:

```kotlin
@Composable
fun SpeedDial() {
    val fabItems = listOf(
        FabItem(
            Icons.Filled.ShoppingCart,
            "Shopping Cart"
        ) { /*TODO*/ },
        FabItem(
            Icons.Filled.Favorite,
            "Favorite"
        ) { /*TODO*/ }
    )
    MultiFloatingActionButton(
        fabIcon = Icons.Filled.Add,
        items = fabItems,
        showLabels = true
    )
}
```


## Credits
This project is based on [ComposeCompanion by ComposeAcademy](https://github.com/ComposeAcademy/ComposeCompanion).