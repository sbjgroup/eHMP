name             'rdk_provision'
maintainer       'Accenture Federal Services'
maintainer_email 'team-milkyway@vistacore.us'
license          'All rights reserved'
description      'Installs/Configures rdk_provision'
long_description IO.read(File.join(File.dirname(__FILE__), 'README.md'))
version          "2.0.204"

depends "machine", "2.0.40"

depends "rdk", "2.0.96"
depends "jbpm", "2.0.97"