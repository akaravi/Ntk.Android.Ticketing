# Ntk.Android.Ticketing

White-label Android support and content app — ticketing, FAQ, news, articles, and polls on the NTK CMS platform.

## Overview

`Ntk.Android.Ticketing` delivers customer support workflows (tickets, FAQ, feedback) alongside CMS news and magazine modules. Multiple main-activity themes (`MainActivity_1` … `MainActivity_4`) allow different launcher layouts for white-label deployments.

## App info

| Field | Value |
|-------|-------|
| Application ID | `ntk.android.ticketing.APPNTK` |
| Package | `ntk.android.ticketing` |
| Base library version | `1.6.43` (JitPack) |
| `compileSdk` / `targetSdk` | 33 |
| `minSdk` | 17 |

## Main features

### Support

- Ticket list, create, answer, and search (from BaseActivity)
- FAQ and help
- Feedback and invite-friends flows
- Polling / surveys

### CMS content

- News list, detail, and search
- Article / magazine list, detail, search, and category views

### Platform

- Multiple home screen layouts (`MainActivity_1`–`_4`)
- About us (fullscreen theme)
- SMS receiver for auth / verification
- Sentry monitoring
- APK install permission for in-app updates

## Stack

- [Ntk.Android.BaseActivity](https://github.com/akaravi/Ntk.Android.BaseActivity) via JitPack `1.6.43`
- Retrofit 2.5 + RxJava 2
- ButterKnife, EventBus, Lottie, Flexbox
- Localization library (`com.akexorcist:localization`)
- Flowing drawer navigation

## Local build

```bash
./gradlew :app:assembleDebug
```

Uncomment composite `baseActivity` / `baseApi` module includes in `settings.gradle` for sibling-repo development.

## JitPack dependency

```gradle
api "com.github.akaravi:Ntk.Android.BaseActivity:1.6.43"
```

## Related projects

| Repository | Role |
|------------|------|
| [Ntk.Android.Base](https://github.com/akaravi/Ntk.Android.Base) | CMS API client |
| [Ntk.Android.BaseActivity](https://github.com/akaravi/Ntk.Android.BaseActivity) | Shared UI library |
| [Ntk.Android.Biography](https://github.com/akaravi/Ntk.Android.Biography) | Biography app |
| [Ntk.Android.Estate](https://github.com/akaravi/Ntk.Android.Estate) | Estate app |

## License

Proprietary — NTK.
