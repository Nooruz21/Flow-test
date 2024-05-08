import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("org.jetbrains.dokka")
}

android {
    namespace = "com.awb.flowtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.awb.flowtest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}
tasks.dokkaHtml {
    outputDirectory.set(layout.buildDirectory.dir("documentation/html"))
}
tasks.dokkaHtml.configure {
    dokkaSourceSets {
        named("main") {
            skipDeprecated.set(true)
            includeNonPublic.set(false)
            skipEmptyPackages.set(true)
            reportUndocumented.set(true)
            documentedVisibilities.set(setOf(DokkaConfiguration.Visibility.PUBLIC, DokkaConfiguration.Visibility.PROTECTED))
            perPackageOption {
                matchingRegex.set(".*internal.*")
                suppress.set(true)
            }
            pluginsMapConfiguration.set(
                mapOf("org.jetbrains.dokka.base.DokkaBase" to """{ "separateInheritedMembers": true }""")
            )
            perPackageOption {
                matchingRegex.set("com.awb.flowtest.ui.*")
                suppress.set(false) // Ensure UI components are fully documented
                includeNonPublic.set(true) // Optionally include non-public members for detailed internal documentation
            }
        }
    }
}
/*tasks.withType<DokkaTask>().configureEach {
//Создает карту конфигурации, указывая, что унаследованные члены должны отображаться отдельно.
    pluginsMapConfiguration.set(
        mapOf("org.jetbrains.dokka.base.DokkaBase" to """{ "separateInheritedMembers": true}""")
    )
    dokkaSourceSets.configureEach {
        //  не включать в документацию непубличные элементы (такие как private и internal классы и методы).
        includeNonPublic.set(false)
        // пропустить пакеты, которые не содержат документируемых элементов, что помогает избежать создания пустых разделов в документации.
        skipEmptyPackages.set(true)
        // пропустить устаревшие (deprecated) элементы при генерации документации.
        skipDeprecated.set(true)
        //Призывает Dokka выдавать предупреждения о публичных элементах, которые не имеют документационных комментариев, что может помочь улучшить качество документации.
        reportUndocumented.set(true)
//        Определяет уровни доступа элементов, которые должны быть включены в документацию. В данном случае включены только публичные элементы
        documentedVisibilities.set(
            setOf(
                DokkaConfiguration.Visibility.PUBLIC,
                DokkaConfiguration.Visibility.PRIVATE,
                DokkaConfiguration.Visibility.PROTECTED
            )
        )
         // perPackageOption: Позволяет настроить параметры документации для определенных пакетов.
        perPackageOption {
           //Применяет настройки к пакетам, имена которых соответствуют данному регулярному выражению. В этом случае к любым пакетам, содержащим слово "internal".
            matchingRegex.set(".*internal.*")
//            Указывает Dokka не документировать содержимое этих пакетов.
            suppress.set(true)
        }
    }
}*/
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Core
    implementation(libs.androidx.core.ktx.v180)

    // Appcompat
    implementation(libs.androidx.appcompat.v142)

    // Material Design Components
    implementation(libs.material.v161)

    // UI Components
    implementation(libs.androidx.constraintlayout)

    // Navigation
    val nav_version = "2.4.2"
    implementation(libs.androidx.navigation.fragment.ktx.v242)
    implementation(libs.androidx.navigation.ui.ktx.v242)

    // ViewBindingPropertyDelegate | | To use only without reflection variants of viewBinding
    implementation(libs.viewbindingpropertydelegate.noreflection)

    dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:1.9.20")

}