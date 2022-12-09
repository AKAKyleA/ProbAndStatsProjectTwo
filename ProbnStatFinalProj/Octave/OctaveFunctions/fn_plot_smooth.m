function plottedSmooth = fn_plot_smooth(x,y)
  
  pkg install -forge data-smoothing %installs data-smooth package from octave forge
  pkg load data-smoothing%loads data-smooth package from octave forge
  [yh, lambda] = regdatasmooth(x,y);% uses function in data-smooth package to get 
                                    % yh which is smoothed y points
  plot(x,yh);% plots graph
  title('3x + 5 = y smoothed');% adds title
  set(gca,'fontsize',24);% increases the font
  xlabel('Variable x');% adds x label
  ylabel('Variable y');% adds y label
  
  end