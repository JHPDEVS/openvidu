/*
 * (C) Copyright 2017-2020 OpenVidu (https://openvidu.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.openvidu.server.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.openvidu.server.config.OpenviduConfig;

/**
 * This class serves recording files from host folder indicated in configuration
 * property OPENVIDU_RECORDING_PATH
 * 
 * @author Pablo Fuente (pablofuenteperez@gmail.com)
 */
@Configuration
public class RecordingsResourceHandler implements WebMvcConfigurer {

	@Autowired
	OpenviduConfig openviduConfig;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String recordingsPath = openviduConfig.getOpenViduRecordingPath();
		registry.addResourceHandler("/recordings/**").addResourceLocations("file:" + recordingsPath);
	}

}
