# laravel-env-switch | PHPStorm Laravel Plugin

[![Version](https://img.shields.io/jetbrains/plugin/v/19019-laravel-env-switch.svg)](https://plugins.jetbrains.com/plugin/19019-laravel-env-switch)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/19019-laravel-env-switch.svg)](https://plugins.jetbrains.com/plugin/19019-laravel-env-switch)


<!-- Plugin description -->
**Plugins for proper environment file switching**

### env list (환경 목록)
- .env.local : Environment files for local
- .env.pre : Environment files for pre(test,development)
- .env.live : Environment files for live

### Description (설명)
1. PHPStorm > Tools > Laravel Env Switch click!
  - (PHPStorm > 도구 > Laravel Env Switch 클릭!)
2. Please select the desired work environment env[local|pre|live]
  - 원하는 작업 환경[local|pre|live]을 선택하세요.
3. If the .env and .env.{#type} files exist, the contents of the .env file are changed to the .env.{#type} contents. (#type : This is the environment you chose.)
  - .env파일과 .env.{#type} 파일이 모두 존재하면 .env 파일이 .env.{#type} 내용으로 변경됩니다.(#type : 여러분이 선택한 환경을 뜻합니다.)
4. If you don't have a .env file or .env.{#type} file, It does not switch and creates a .env file or .env.#{type} file.
  - .env 파일 혹은 .env.{#type} 파일이 존재하지 않는 경우 스위칭되지 않으며 존재하지 않는 파일을 생성해줍니다.
5. Available for any project that uses the .env file as an environment file
  - .env 파일을 환경 파일로 사용하는 모든 프로젝트에서 사용 가능합니다.

See the [laravel-env-switch](https://plugins.jetbrains.com/plugin/19019-laravel-env-switch) for more information!
  - 더 자세한 정보는 플러그인 마켓에서 확인해주세요!
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
