[33mcommit 53ac03d7a8f574a56f7475c3467735c0239b68e8[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: 1sy <736165936@qq.com>
Date:   Fri Mar 13 15:29:43 2020 +0800

    商城整合redis并实现基本查询

[1mdiff --git a/.idea/libraries/Maven__com_github_theborakompanioni_thymeleaf_extras_shiro_2_0_0.xml b/.idea/libraries/Maven__com_github_theborakompanioni_thymeleaf_extras_shiro_2_0_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..9430241[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__com_github_theborakompanioni_thymeleaf_extras_shiro_2_0_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.github.theborakompanioni:thymeleaf-extras-shiro:2.0.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/github/theborakompanioni/thymeleaf-extras-shiro/2.0.0/thymeleaf-extras-shiro-2.0.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/github/theborakompanioni/thymeleaf-extras-shiro/2.0.0/thymeleaf-extras-shiro-2.0.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/github/theborakompanioni/thymeleaf-extras-shiro/2.0.0/thymeleaf-extras-shiro-2.0.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__commons_beanutils_commons_beanutils_1_9_3.xml b/.idea/libraries/Maven__commons_beanutils_commons_beanutils_1_9_3.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..687a60e[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__commons_beanutils_commons_beanutils_1_9_3.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: commons-beanutils:commons-beanutils:1.9.3">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-beanutils/commons-beanutils/1.9.3/commons-beanutils-1.9.3.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-beanutils/commons-beanutils/1.9.3/commons-beanutils-1.9.3-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-beanutils/commons-beanutils/1.9.3/commons-beanutils-1.9.3-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__commons_collections_commons_collections_3_2_2.xml b/.idea/libraries/Maven__commons_collections_commons_collections_3_2_2.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..13afda2[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__commons_collections_commons_collections_3_2_2.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: commons-collections:commons-collections:3.2.2">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_lettuce_lettuce_core_5_2_1_RELEASE.xml b/.idea/libraries/Maven__io_lettuce_lettuce_core_5_2_1_RELEASE.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..9b43b77[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_lettuce_lettuce_core_5_2_1_RELEASE.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.lettuce:lettuce-core:5.2.1.RELEASE">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/lettuce/lettuce-core/5.2.1.RELEASE/lettuce-core-5.2.1.RELEASE.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/lettuce/lettuce-core/5.2.1.RELEASE/lettuce-core-5.2.1.RELEASE-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/lettuce/lettuce-core/5.2.1.RELEASE/lettuce-core-5.2.1.RELEASE-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_buffer_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_buffer_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..a42dce8[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_buffer_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-buffer:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-buffer/4.1.43.Final/netty-buffer-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-buffer/4.1.43.Final/netty-buffer-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-buffer/4.1.43.Final/netty-buffer-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_codec_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_codec_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..595a17c[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_codec_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-codec:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-codec/4.1.43.Final/netty-codec-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-codec/4.1.43.Final/netty-codec-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-codec/4.1.43.Final/netty-codec-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_common_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_common_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..fd4c349[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_common_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-common:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-common/4.1.43.Final/netty-common-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-common/4.1.43.Final/netty-common-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-common/4.1.43.Final/netty-common-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_handler_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_handler_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..bfcd64b[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_handler_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-handler:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-handler/4.1.43.Final/netty-handler-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-handler/4.1.43.Final/netty-handler-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-handler/4.1.43.Final/netty-handler-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_resolver_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_resolver_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..d9b941e[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_resolver_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-resolver:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-resolver/4.1.43.Final/netty-resolver-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-resolver/4.1.43.Final/netty-resolver-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-resolver/4.1.43.Final/netty-resolver-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_netty_netty_transport_4_1_43_Final.xml b/.idea/libraries/Maven__io_netty_netty_transport_4_1_43_Final.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..3829801[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_netty_netty_transport_4_1_43_Final.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.netty:netty-transport:4.1.43.Final">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-transport/4.1.43.Final/netty-transport-4.1.43.Final.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-transport/4.1.43.Final/netty-transport-4.1.43.Final-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/netty/netty-transport/4.1.43.Final/netty-transport-4.1.43.Final-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__io_projectreactor_reactor_core_3_3_1_RELEASE.xml b/.idea/libraries/Maven__io_projectreactor_reactor_core_3_3_1_RELEASE.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..408e147[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__io_projectreactor_reactor_core_3_3_1_RELEASE.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: io.projectreactor:reactor-core:3.3.1.RELEASE">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/projectreactor/reactor-core/3.3.1.RELEASE/reactor-core-3.3.1.RELEASE.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/projectreactor/reactor-core/3.3.1.RELEASE/reactor-core-3.3.1.RELEASE-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/io/projectreactor/reactor-core/3.3.1.RELEASE/reactor-core-3.3.1.RELEASE-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__org_apache_commons_commons_pool2_2_7_0.xml b/.idea/libraries/Maven__org_apache_commons_commons_pool2_2_7_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..dbf3aa4[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__org_apache_commons_commons_pool2_2_7_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: org.apache.commons:commons-pool2:2.7.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/commons/commons-pool2/2.7.0/commons-pool2-2.7.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/commons/commons-pool2/2.7.0/commons-pool2-2.7.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/commons/commons-pool2/2.7.0/commons-pool2-2.7.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__org_apache_shiro_shiro_cache_1_4_1.xml b/.idea/libraries/Maven__org_apache_shiro_shiro_cache_1_4_1.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..70fa7f6[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__org_apache_shiro_shiro_cache_1_4_1.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: org.apache.shiro:shiro-cache:1.4.1">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/shiro/shiro-cache/1.4.1/shiro-cache-1.4.1.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/shiro/shiro-cache/1.4.1/shiro-cache-1.4.1-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/shiro/shiro-cache/1.4.1/shiro-cache-1.4.1-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/libraries/Maven__org_apache_shiro_shiro_config_core_1_4_1.xml b/.idea/libraries/Maven__org_apache_shiro_shiro_config_core_1_4_1.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b98c4ab[m
[1m--- /dev/null[m
[1m+++ b/.idea/libraries/Maven__org_apache_shiro_shiro_config_core_1_4_1.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: org.apache.shiro:shiro-config-core:1.4.1">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/shiro/shiro-config-core/1.4.1/shiro-config-core-1.4.1.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/org/apache/shiro/shiro-config-core/1.4.1/shiro-config-core-1.4.1-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar