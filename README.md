# laravel-env-switch | PHPStorm Laravel Plugin

![Build](https://github.com/boboram/laravel-env-switch/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->
**Plugins for proper environment file switching**

### env list
- .env.local : Environment files for local
- .env.pre : Environment files for pre(test,development)
- .env.live : Environment files for live

### Description
1. PHPStorm > Tools > Laravel Env Switch > env click!

2. Please select the desired work environment!

3. If you have a .env.{#type} file, The contents of the .env file will be changed to .env.{#type} (#type : This is the environment you chose.)

4. If you don't have a .env file or .env.{#type} file, It does not switch and creates a .env file or .env.#{type} file.

5. Available for any project that uses the .env file as an environment file

See the [laravel-env-switch](https://plugins.jetbrains.com/plugin/19019-laravel-env-switch) for more information!

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "laravel-env-switch"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/boboram/laravel-env-switch/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
