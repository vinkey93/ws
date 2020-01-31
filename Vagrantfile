Vagrant.configure("2") do |config|
 
  config.vm.box = "ubuntu/bionic64"
  config.vm.hostname = "myjenkins"
  config.vm.network "private_network", ip:"192.168.44.10"
  config.vm.provider "virtualbox" do |vb|
	vb.memory="1024"
  end
  config.vm.provision "shell",path:"jenkins.sh"
  
end
