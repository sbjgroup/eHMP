name             'rubygems'
maintainer       'Ryan Hass'
maintainer_email 'Ryan Hass <rhass+community-cookbooks@chef.io>'
license          'Apache-2.0'
description      'Configures rubygems and bundler'
long_description IO.read(File.join(File.dirname(__FILE__), 'README.md'))
version          '1.1.0'

supports 'amazon'
supports 'centos'
supports 'debian'
supports 'fedora'
supports 'freebsd'
supports 'mac_os_x', '>= 10.7.0'
supports 'opensuse'
supports 'opensuseleap'
supports 'oracle'
supports 'redhat'
supports 'scientific'
supports 'smartos'
supports 'solaris2'
supports 'suse'
supports 'ubuntu'
supports 'windows'
supports 'zlinux'

issues_url 'https://github.com/chef-cookbooks/rubygems/issues'
source_url 'https://github.com/chef-cookbooks/rubygems'
chef_version '>= 12.7' if respond_to?(:chef_version)
