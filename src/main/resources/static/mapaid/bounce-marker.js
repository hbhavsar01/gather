/**
 * Copyright (C) 2013 Maxime Hadjinlian <maxime.hadjinlian@gmail.com>
 * All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

!function(){var t=L.Marker.prototype.onAdd,n=L.Marker.prototype.onRemove;L.Marker.mergeOptions({bounceOnAdd:!1,bounceOnAddOptions:{duration:1e3,height:-1},bounceOnAddCallback:function(){}}),L.Marker.include({_toPoint:function(t){return this._map.latLngToContainerPoint(t)},_toLatLng:function(t){return this._map.containerPointToLatLng(t)},_motionStep:function(t){var n=this,o=new Date;n._intervalId=setInterval(function(){var i=new Date-o,e=i/t.duration;e>1&&(e=1);var s=t.delta(e);t.step(s),1===e&&(t.end(),clearInterval(n._intervalId))},t.delay||10)},_bounceMotion:function(t,n,o){var i=L.latLng(this._origLatlng),e=this._dropPoint.y,s=this._dropPoint.x,r=this._point.y-e,a=this;this._motionStep({delay:10,duration:n||1e3,delta:t,step:function(t){a._dropPoint.y=e+r*t-(a._map.project(a._map.getCenter()).y-a._origMapCenter.y),a._dropPoint.x=s-(a._map.project(a._map.getCenter()).x-a._origMapCenter.x),a.setLatLng(a._toLatLng(a._dropPoint))},end:function(){a.setLatLng(i),"function"==typeof o&&o()}})},_easeOutBounce:function(t){return 1/2.75>t?7.5625*t*t:2/2.75>t?7.5625*(t-=1.5/2.75)*t+.75:2.5/2.75>t?7.5625*(t-=2.25/2.75)*t+.9375:7.5625*(t-=2.625/2.75)*t+.984375},bounce:function(t,n){this._origLatlng=this.getLatLng(),this._bounce(t,n)},_bounce:function(t,n){"function"==typeof t&&(n=t,t=null),t=t||{duration:1e3,height:-1},"number"==typeof t&&(t.duration=arguments[0],t.height=arguments[1]),this._origMapCenter=this._map.project(this._map.getCenter()),this._dropPoint=this._getDropPoint(t.height),this._bounceMotion(this._easeOutBounce,t.duration,n)},_getDropPoint:function(t){this._point=this._toPoint(this._origLatlng);var n;return n=void 0===t||0>t?this._toPoint(this._map.getBounds()._northEast).y:this._point.y-t,new L.Point(this._point.x,n)},onAdd:function(n){this._map=n,this._origLatlng=this._latlng,this.options.bounceOnAdd===!0&&("undefined"!=typeof this.options.bounceOnAddDuration&&(this.options.bounceOnAddOptions.duration=this.options.bounceOnAddDuration),"undefined"!=typeof this.options.bounceOnAddHeight&&(this.options.bounceOnAddOptions.height=this.options.bounceOnAddHeight),this._dropPoint=this._getDropPoint(this.options.bounceOnAddOptions.height),this.setLatLng(this._toLatLng(this._dropPoint))),t.call(this,n),this.options.bounceOnAdd===!0&&this._bounce(this.options.bounceOnAddOptions,this.options.bounceOnAddCallback)},onRemove:function(t){clearInterval(this._intervalId),n.call(this,t)}})}();
