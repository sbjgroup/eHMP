name						 "cdsdashboard"
maintainer       "Agilex"
maintainer_email "team-milkyway@vistacore.us"
license          "All rights reserved"
description      "Installs/Configures cdsdashboard"
long_description IO.read(File.join(File.dirname(__FILE__), 'README.md'))
version          "2.0.21"

supports "centos"

depends "common", "2.0.12"

#############################
# 3rd party
#############################
depends "apache2", "=3.0.1"
depends "build-essential", "=2.2.2"

#############################
# wrapper_cookbook
#############################
depends "java_wrapper", "2.0.6"
depends "apache2_wrapper", "2.0.5"

#############################
# custom_cookbook
#############################
depends "tomcat", "2.0.7"